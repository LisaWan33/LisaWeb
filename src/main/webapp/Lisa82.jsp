<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.lisa.api.*" %>
<%
//沒拿到session不能來，登入進去畫面
	if(session.getAttribute("member")==null){
	response.sendRedirect("Lisa80.jsp");
}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
			Welcome, ${member.realname }
			<hr />
			<a href="logout.jsp">Logout</a>
			<!-- 登出 -->
			
	</body>
</html>