package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;//enctype:編碼格式

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lisa06")
public class Lisa06 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet()");
//		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost()");
		request.setCharacterEncoding("UTF-8");
		String account =request.getParameter("account");
		String passwd  =request.getParameter("passwd");
		String gender  =request.getParameter("gender");
		
//		System.out.printf("%s :%s",account,passwd);
		String[] habbits =  request.getParameterValues("habbit");
		
		//-------------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.printf("%s :%s :%s", account,passwd,gender);
		response.flushBuffer();
		
	}

}
