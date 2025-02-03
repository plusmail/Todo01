<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String num1Str = request.getParameter("num1");
    String num2Str = request.getParameter("num2");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>NUM1 : <%= num1Str %></h1>
<h1>NUM2 : <%= num2Str %></h1>

</body>
</html>
