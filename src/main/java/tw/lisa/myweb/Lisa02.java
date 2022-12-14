package tw.lisa.myweb;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lisa02")
public class Lisa02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//response:javaEE(javax.servlet.http.HttpServletResponse) =>.getWriter() 傳回paintWriter(java.io)=>呼叫append方法，把字串加在後面(CharSequence)
		
		Enumeration<String> names =request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name =names.nextElement();
			String value =request.getHeader(name);
			System.out.printf("%s => %s\n",name,value);
		}
			
		}
	}
