<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>

<h1>Todo 상세보기</h1>
<div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" readonly>
</div>
<div>
    <input type="text" name="dueDate" value="${dto.dueDate}" readonly>
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly>
</div>

<a href="/todo/modify?tno=${dto.tno}">수정으로 이동</a>
&nbsp;
<%--<a href="/todo/remove?tno=${dto.tno}">삭제하기</a>--%>
<form action="/todo/remove" method="post" >
    <input type="hidden" name="tno" value="${dto.tno}">
    <input type="submit" value="삭제">
</form>
&nbsp;
<a href="/todo/list">목록보기로 이동</a>

</body>
</html>
