<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kroryi.DTO.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<nav>
    <ul>
        <li><a href="/">홈</a> </li>
        <li><a href="/board/list">게시판</a></li>
        <li><a href="/member/list">회원관리</a></li>
        <li><a href="/todo/list">할일관리</a></li>

        <c:choose>
            <c:when test="${loginInfo.password_match == 1}">
                <li><a href="/loginout">로그아웃</a></li>
                <li class="profile-menu">
                    <a href="">프로필</a>
                    <div class="dropdown-content">
                        <p><strong>ID : </strong> ${loginInfo.mid}</p>
                        <p><strong>이름 : </strong> ${loginInfo.mname}</p>
                        <p><strong>Email : </strong> ${loginInfo.memail}</p>
                    </div>

                </li>
            </c:when>
            <c:otherwise>
                <li><a href="/login">로그인</a></li>
            </c:otherwise>
        </c:choose>

    </ul>
</nav>