package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lisa04")
public class Lisa04 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		
//		Enumeration<String> names =request.getParameterNames();
//		while(names.hasMoreElements()) {
//			String name = names.nextElement();		
//			String value = request.getParameter(name);
//			System.out.printf("%s : %s \n", name ,value);
//	}

	
	String x= request.getParameter("x");
	String y= request.getParameter("y");
	
	int intx =Integer.parseInt(x);
	int inty =Integer.parseInt(y);
	int result = intx + inty;
	
	//---------------輸出--------------------
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out =response.getWriter();
	out.printf("%d + %d = %d", intx, inty, result);
	response.flushBuffer();
	}
}

