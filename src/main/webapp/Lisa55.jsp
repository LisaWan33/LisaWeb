<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="x" value="10"></c:set> <!-- pageContext x=10 -->
<c:set var="x" value="123" scope="request"></c:set> <!-- request x=10 -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		Page: ${x }<br />
		Request: ${requestScope.x }<br />
		<c:out value="Hello,World"></c:out><br />
		<%= "Hello,World" %><br />
		
		<c:out value="${x }"></c:out><br />
		<c:out value="${param.i }" default="no-Value"></c:out><br />
		
		<jsp:useBean id="member" class="tw.lisa.api.Member"></jsp:useBean>
		<c:set target="${member }" property="id">1</c:set>
		<c:set target="${member }" property="account">Brad</c:set>
		<c:set target="${member }" property="realname">BradChao</c:set>
		${member.id }:${member.account }:${member.realname }<br />
		${member}
		<hr />
		<c:remove var="member"/><!-- var不是value、target(記憶體的物件)、放id -->
		${member}
	</body>
</html>