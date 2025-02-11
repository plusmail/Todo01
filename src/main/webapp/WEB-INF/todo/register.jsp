
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>

<h1>Todo 등록 화면</h1>
<form action="/todo/register" method="post">
    <input type="text" name="title">
    <input type="date" name="dueDate">
    <button type="reset">취소</button>
    <button type="submit">등록</button>
</form>
</body>
</html>
