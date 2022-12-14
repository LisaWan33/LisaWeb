<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 格式化 -->
		<%
			Locale locale = request.getLocale();
			String ll = locale.getLanguage();
			String cc = locale.getCountry();
			String lang = ll + "_" + cc;
			pageContext.setAttribute("lang", lang);
		%>
		
		Country: ${pageContext.request.locale.country }<br />
		Country: <%= locale.getDisplayCountry() %><br />
		Language: <%= locale.getLanguage() %><br />
		Language: <%= locale.getDisplayLanguage() %><br />
		<hr />
		
		<fmt:setLocale value="${lang }"/>
		<fmt:setBundle basename="res"/> <!-- 前字碼 (連結自創的properties)-->
		<h1><fmt:message key="companyName" /></h1>
		<hr />
		<fmt:message key="hello" />,<fmt:message key="world" />
		<hr />
		
		<%
			Date now =new Date();
			out.print(now);
			pageContext.setAttribute("now", now);
		%>
		<hr />
		
		<h3>Taipei</h3>
		<fmt:setTimeZone value="Asia/Taipei"/>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/> <!-- 格式化動作 -->
		
		<hr />
		<h3>Tokyo</h3>
		<fmt:setTimeZone value="Asia/Tokyo"/>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/> <!-- 格式化動作 -->
		
		<hr />
		<h3>Germany</h3>
		<fmt:setTimeZone value="Asia/Berlin"/>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/> <!-- 格式化動作 -->
	
	
	
		<hr />
		<fmt:setLocale value="de_de"/>
		<fmt:formatNumber value="1234567.123456"
		 type="currency" currencyCode="EUR"/> <!-- 貨幣 -->
			
		
	
	</body>
</html>