<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String exceptionType = exception.getClass().getName(); // isErrorPage 선언으로 사용 가능
        String exceptionMessage = exception.getMessage();
    %>
    <h1><%= exceptionType %></h1>
    <h2><%= exceptionMessage %></h2>
</body>
</html>
