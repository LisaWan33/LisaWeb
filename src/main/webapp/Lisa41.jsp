<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String x =(String)request.getAttribute("x");
	String y =(String)request.getAttribute("y");
	String r =(String)request.getAttribute("r");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 style="color: pink"> Lisa Big Company V1</h1>
		<hr/>
		<form action="Lisa40.jsp">
			<input type="text" name="x" value="<%= x %>"/>
			+
			<input type="text" name="y" value="<%= y %>"/>
			<input type="submit" value="="/>
			<span><%=r %></span>
		</form>
		<hr />
		
	</body>
</html>