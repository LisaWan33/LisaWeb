<%@page import="tw.lisa.api.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//檢查
	String account = request.getParameter("account");
	String passwd = request.getParameter("passwd");
	
	if(account.equals("lisa3230") && passwd.equals("123456")){
			Member member =new Member();
			member.setId(1);
			member.setAccount("lisa");
			member.setRealname("Lisa");
			
			session.setAttribute("member", member);
			response.sendRedirect("Lisa82.jsp");
	}else{
		session.invalidate();
		response.sendRedirect("Lisa80.jsp");
	}


%>