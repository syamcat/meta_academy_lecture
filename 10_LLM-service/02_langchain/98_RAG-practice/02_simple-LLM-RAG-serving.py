from dotenv import load_dotenv
from langchain_openai import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_core.prompts import ChatPromptTemplate
from langchain_community.chat_models import ChatOllama
from langchain_core.runnables import RunnablePassthrough

# 랭스미스 연결
load_dotenv(dotenv_path="../99_env/.env")

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()

# Local FAISS 로드 (임베딩 해둔 파일 디코딩)
vectorstore = FAISS.load_local(
	"./db/faiss",
	embedding_model,
	allow_dangerous_deserialization=True
)

# retriever 생성
retriever = vectorstore.as_retriever(
	search_type="similarity",
	search_kwars={"k": 5}
)
# vectorstore에 저장된 내용중 빵에 관련된 내용 출력
# print(retriever.batch(["빵"]))

# prompt 생성
message = """
Answer this question using the provided context only.

{question}

Context:
{context}
"""

# 프롬프트 템플릿 생성
prompt = ChatPromptTemplate.from_messages(
	[
		("system", "당신은 마작을 진행하는 사람입니다. 룰을 설명하는 역할이니 어린아이도 알아들을 수 있도록 쉽게 설명하세요"),
		("human", message)
	]
)

# LLM 모델 로드
model = ChatOllama(
	model = "gemma2:2b",
	temperature=0.3
)

# RAG chain 생성
chain = {"context": retriever, "question": RunnablePassthrough()} | prompt | model


from fastapi import FastAPI, Form
from typing import Annotated

app = FastAPI()

@app.get("/")
async def read_root():
    return {"message": "Hello, World!"}

@app.post("/mahjong", tags=["마작"])
async def MahJong(question: Annotated[str, Form()]):
	return {"answer": chain.invoke(question).content}