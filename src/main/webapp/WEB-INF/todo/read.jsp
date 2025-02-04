
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo 상세보기</h1>
${dto.tno} - ${dto.title} - ${dto.dueDate} - ${dto.finished}
<form action="/todo/modify" method="get">

    <button type="submit">수정으로 이동</button>

</form>
</body>
</html>
