<%@page import="javax.print.DocFlavor.STRING"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String key = request.getParameter("key"); 
	//直接在頁籤書key值，可能是電話、地址的一些關鍵字

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn =DriverManager.getConnection(
			"jdbc:mysql://localhost:3309/eeit53","root","root");
	
	
	PreparedStatement pstmt;
	String sql ="SELECT * FROM food";
	
	if(key!= null){
		sql +=" WHERE name like? OR tel like ? OR addr like?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "%"+key+"%");
		pstmt.setString(2, "%"+key+"%");
		pstmt.setString(3, "%"+key+"%");
	}else{
		pstmt=conn.prepareStatement(sql);
	}
	
	ResultSet rs = pstmt.executeQuery();
	
	JSONArray root = new JSONArray();
	while (rs.next()){
		JSONObject obj = new JSONObject();
		obj.put("id", rs.getString("id"));
		obj.put("name", rs.getString("name"));
		obj.put("tel", rs.getString("tel"));
		obj.put("addr", rs.getString("addr"));
		root.put(obj);
	}
	
	out.print(root.toString().trim());
%>