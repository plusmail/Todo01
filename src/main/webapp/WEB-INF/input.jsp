<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>여기는 input.jsp야 InputController에서 forward함1111</h1>

<form action="/calc/input" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <button type="submit">전송</button>
</form>
</body>
</html>
