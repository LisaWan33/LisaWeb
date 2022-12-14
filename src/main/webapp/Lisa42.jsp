<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String x =(String)request.getAttribute("x");
	String y =(String)request.getAttribute("y");
	String op=request.getParameter("op");
	String r= "";	

	try{
		int intX = Integer.parseInt(x);
		int intY = Integer.parseInt(y);
		int intR = 0, mod= 0;
		
		switch(op){ //case每一個都為常數，所以就要用字串""
			case "1":
				intR =intX + intY; r =intR+""; break;
			case "2":
				intR =intX - intY; r =intR+""; break;
			case "3":
				intR =intX * intY; r =intR+""; break;
			case "4":
				intR =intX / intY; mod = intX % intY ;r =intR + "..." + mod ; break;
			}
		}catch(Exception e){
			x = y = r =op= ""; //沒有op，就會出現Lisa33.jsp
	}
	
	
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 style="color:blue;"> Lisa Big Company V2</h1>
		<hr/>
			<form action="brad40.jsp">
			<input name="x" value="<%= x %>" />
			<select name="op">
				<option value="1" <%= (op.equals("1")?"selected":"") %>>加</option>
				<option value="2" <%= (op.equals("2")?"selected":"") %>>減</option>
				<option value="3" <%= (op.equals("3")?"selected":"") %>>乘</option>
				<option value="4" <%= (op.equals("4")?"selected":"") %>>除</option>
			</select>
			<input name="y" value="<%= y %>" />
			<input type="submit" value="=">
			<%= r %>
		</form>
		<hr />
		
	</body>
</html>