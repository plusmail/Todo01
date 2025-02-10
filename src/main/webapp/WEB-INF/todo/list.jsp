<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%--<%@ taglib prefix="fmt" uri="https://jakarta.ee/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .todo-list {
        list-style: none;
        padding: 0;
        margin: 0;
        width: 100%;
        max-width: 600px;

    }
    .todo-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 12px 16px;
        margin: 6px 0;
        background: #f9f9f9;
        border-radius: 8px;
        transition: 0.3s;
        box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
    }
    .todo-item:hover {
        background: #e6e6e6;
    }

    .todo-text {
        font-size: 16px;
        font-weight: 500;
        color : #333;
        text-decoration: none;
    }
    .todo-item.completed .todo-text {
        text-decoration: line-through;
        color: #888;
    }
    .todo-date {
        font-size: 14px;
        color: #666;
    }

    a {
        text-decoration: none;
    }

    .register-button {
        display: block;
        width: fit-content;
        margin : 20px auto;
        padding: 12px 20px;
        background: #007bff;
        color : white;
        border-radius: 8px;
        font-size : 16px;
        text-align: center;
        transition: 0.3s;
    }
    .register-button:hover {
        background: #0056b3;
    }
</style>
<body>
<h1>Todo 목록보기</h1>
<form action="${cp}/logout" method="post">
    <button>로그아웃</button>
</form>

<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li class="todo-list">
            <span>${dto.getTno()}</span>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.getTitle()}</a></span>
            <span class="todo-date">${dto.getDueDate()}</span>
            <span>${dto.isFinished()}</span>
        </li>
    </c:forEach>


</ul>
<form action="/todo/register" method="get">
    <button type="submit" class="register-button">등록페이지 이동</button>
</form>
<script>

</script>
</body>
</html>
