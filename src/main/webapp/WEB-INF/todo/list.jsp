
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix="fmt" uri="https://jakarta.ee/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo 목록보기</h1>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>${dto.getTno()}- ${dto.getTitle()} - ${dto.getDueDate()} - ${dto.isFinished()}</li>
    </c:forEach>

</ul>
<form action="/todo/register" method="get">
    <button type="submit">등록페이지 이동</button>
</form>

</body>
</html>
