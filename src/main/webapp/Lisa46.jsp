<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- EL:Expression Language -->  
<jsp:useBean id="member" class= "tw.lisa.api.Member">
</jsp:useBean>
<jsp:setProperty property="id" name="member" value="${param.id }" />
<jsp:setProperty property="account" name="member" value="${param.account }" />
<jsp:setProperty property="realname" name="member" value="${param.realname }" />
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here //EL=$+{}</title>
	</head>
	<body>
		Member:
		<jsp:getProperty property="id" name="member"/> :
		<jsp:getProperty property="account" name="member"/> :
		<jsp:getProperty property="realname" name="member"/>
		<hr />
		ID: ${member.id }<br />
		Account: ${member.account }<br />
		Realname: ${member.realname }<br />
		<hr />
		<jsp:declaration> //宣告
			Integer a;
			String b;
		</jsp:declaration>
		<jsp:scriptlet> //放java
			a = 10; b = "brad";
		</jsp:scriptlet>
		
		a = <jsp:expression>a </jsp:expression><br />
		b = <jsp:expression>b</jsp:expression><br />
		<jsp:expression>member</jsp:expression><br />
		${member }
		<!--呈現  -->
	</body>
</html>