<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%--<%@ taglib prefix="fmt" uri="https://jakarta.ee/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo 목록보기</h1>
<jsp:include page="/menu.jsp"/>

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
