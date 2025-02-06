<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="fmt" uri="https://jakarta.ee/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .member-list {
        list-style: none;
        padding: 0;
        margin: 0;
        width: 100%;
        max-width: 600px;

    }
    .member-item {
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
    .member-item:hover {
        background: #e6e6e6;
    }

    .member-text {
        font-size: 16px;
        font-weight: 500;
        color : #333;
        text-decoration: none;
    }
    .member-item.completed .member-text {
        text-decoration: line-through;
        color: #888;
    }
    .member-date {
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
<h1>회원 목록보기</h1>

<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li class="member-list">
            <span>${dto.getMid()}</span>
            <span><a href="/member/read?mid=${dto.mid}">${dto.getMname()}</a></span>
            <span>${dto.getMpw()}</span>
            <span>${dto.getMemail()}</span>
        </li>
    </c:forEach>


</ul>
<form action="/member/register" method="get">
    <button type="submit" class="register-button">등록페이지 이동</button>
</form>
<script>

</script>
</body>
</html>
