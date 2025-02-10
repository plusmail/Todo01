<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<c:set var="aaaa" value="cccc"/>
<c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
</c:if>

<form action="/login" method="post">

    <input type="text" name="mid">
    <input type="password" name="mpw">
    <button type="submit">로그인</button>
    <button type="reset">취소</button>

</form>

</body>
</html>
