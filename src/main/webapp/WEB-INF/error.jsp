<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>오류 발생</title>
</head>
<body>
<h2>오류가 발생 했습니다.</h2>
<p style="color:red;">
    <strong>${errorMessage}</strong>
</p>
<a href="/todo/list">목록으로 이동</a>
</body>
</html>
