<%@page import="tw.lisa.api.Lisa14"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String view ="Lisa41"; //可改41、42，有不同的結果
String viewer= String.format("%s.jsp", view);

String x =request.getParameter("x");
String y =request.getParameter("y");

if(x!=null && y!=null){
	Lisa14 lisa14 =new Lisa14(x,y);
	double r =lisa14.process();
	request.setAttribute("x", x);
	request.setAttribute("y", y);
	request.setAttribute("r", r+"");
	
}else{
	request.setAttribute("x", "");
	request.setAttribute("y", "");
	request.setAttribute("r", "");
}

%>
<jsp:forward page="<%= viewer %>"></jsp:forward>