<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>forward</h1>
    <form action="forward" method="post">
        <label>아이디: </label><input tupe="text" name="userId"><br>
        <label>비밀번호: </label><input type="password" name="password"><br> <!-- type password: 입력이 안 보인다.-->
        <input type="submit" value="로그인">
    </form>
</body>
</html>