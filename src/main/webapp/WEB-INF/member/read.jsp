<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원정보 상세보기</h1>
<div>
    <label for="">아이디:</label>
    <input type="text" name="mid" value="${dto.mid}" readonly>
</div>
<div>
    <label for="">비밀번호: </label>
    <input type="password" name="mpw" value="${dto.mpw}" readonly>
</div>
<div>
    <label for="">이름 :</label>
    <input type="text" name="mname" value="${dto.mname}" readonly>
</div>
<div>
    <label for="">이메일:</label>
    <input type="text" name="memail" value="${dto.memail}" readonly>
</div>

<a href="/member/modify?mid=${dto.mid}">수정으로 이동</a>
&nbsp;
<%--<a href="/member/remove?mid=${dto.mid}">삭제하기</a>--%>
<form action="/member/remove" method="post" >
    <input type="hidden" name="mid" value="${dto.mid}">
    <input type="submit" value="삭제">
</form>
&nbsp;
<a href="/member/list">회원 목록보기로 이동</a>

</body>
</html>
