<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원등록 화면</h1>
<form action="/member/register" method="post">
    <div>
        <label for="">아이디:</label>
        <input type="text" name="mid" required>
    </div>
    <div>
        <label for="">비밀번호: </label>
        <input type="password" required name="mpw">
    </div>
    <div>
        <label for="">비밀번호(재)</label>
        <input type="password" required name="rempw">
    </div>
    <div>
        <label for="">이름 :</label>
        <input type="text" name="mname">
    </div>
    <div>
        <label for="">이메일:</label>
        <input type="email" name="memail">
    </div>
    <button type="reset">취소</button>
    <button type="submit">등록</button>
</form>
</body>
</html>
