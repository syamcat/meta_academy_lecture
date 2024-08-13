package com.ohgiraffers.restapi.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Controller
@RestController // @Controller + @ResponseBody 어노테이션을 메서드들에 붙여주는 어노테이션
@RequestMapping("/response")
public class ResponseRestController {

//    @ResponseBody
    @GetMapping("/hello")
    public String helloworld() {
        System.out.println("hello world");
        return "hello, world!";
    }

    @GetMapping("/random")
    public int getRandomNumber() {
        return (int) (Math.random() * 10) + 1;
    }

    @GetMapping("/message")
    public Message getMessage() {

        return new Message(200, "메세지를 응답합니다."); // 객체는 자동으로 JSON으로 컨버팅해서 반환해준다.
        // 과거에는 GSON, JackSON 이라고 하는 형식에서 JSON으로 변환하는 작업을 해주는 메세지 컨버터를 사용해야 했다.
    }

    @GetMapping("/list")
    public List<String> getList() {
        return List.of(new String[] { "사과", "바나나", "복숭아"});
    }

    @GetMapping("/map")
    public Map<Integer, String> getMap() {

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "정상 응답"));
        messageList.add(new Message(404, "페이지를 찾을 수 없습니다."));
        messageList.add(new Message(500, "개발자의 잘못입니다."));

        return messageList
                .stream()
                .collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    // 헤더에 반환값이 이미지 라는 것을 알려줌 + 이미지 형태로 출력하게 해줌
    public byte[] getImage() throws IOException {   // 이미지는 byte 형태로 반환된다.
        return new FileInputStream(
                new File("/Users/dohyun/programming/metaverse/lecture/08_JPA/chap09-rest-api/src/main/java/com/ohgiraffers/restapi/section01/response/sample.png")).readAllBytes();
    }

    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {

        return ResponseEntity.ok(new Message(123, "hello world"));
    }

}
