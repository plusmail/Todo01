<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>첫 페이지</title>
</head>
<body>
<h1>웹 개발 워크북 실습</h1>
<%--컴파일 시점에 다른 JSP파일을 현재의 JSP에 포함--%>
<%--<%@ include file="/WEB-INF/menu.jsp"%>--%>
<%--실행 시점에 menu.jsp를 로드 하는 방식--%>
<jsp:include page="menu.jsp"/>

</body>
</html>
