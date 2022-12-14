<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.lisa.api.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
	<c:if test="${!empty param.account }">
	<!-- 不是空的話 -->
		<c:if test="${pageContext.request.method=='GET'}">
		<!-- 拿到get的不要 -->
			<c:redirect url="Lisa61.jsp"></c:redirect>
			<!-- 轉走，轉回Lisa61.jsp -->
		</c:if>
		<!-- 準備要新增 -->
		<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3309/eeit53"
		user="root"
		password="root" 
		/>
		
		<sql:update>
			INSERT INTO member (account, password,realname) VALUES(?,?,?)
			<sql:param>${param.account }</sql:param>
			<sql:param>${LisaUtils.encPasswd($param.passwd) }</sql:param>
			<sql:param>${param.realname }</sql:param>
		</sql:update>
		<c:redirect url="Lisa61.jsp"></c:redirect>
		
	</c:if>
	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post">
			Account:  <input name="account" /><br/>
			Password: <input type="password" name="password" /><br/>
			Realname: <input name="realname" /><br/>
			<input type="submit" value="Add" /><br/>
			
		</form>
	</body>
</html>