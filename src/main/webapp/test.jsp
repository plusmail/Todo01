<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kroryi.DTO.MemberDTO" %>

<%
    String mid = request.getParameter("mid");
    String mpw = request.getParameter("mpw");
%>

<%
    if (mid.equals("test")) {
%>
        <%=mid%>님 방문을 환경합니다.
<%
    }else{
%>
        잘못 입력 하셨습니다.
<%
    }
%>
