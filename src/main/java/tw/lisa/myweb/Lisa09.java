package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lisa09
 */
@WebServlet("/Lisa09")
public class Lisa09 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		

//		RequestDispatcher dispatcher=request.getRequestDispatcher("Lisa09.html");
//		RequestDispatcher dispatcher=
//				request.getRequestDispatcher("Lisa10?key3=33&key1=11");
		
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("Lisa10");
		request.setAttribute("key3", "33");
		request.setAttribute("key4", "77");
		
		//----------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.print("Hello,Lisa <br/>");
		out.print("<hr />");
		
		dispatcher.include(request, response);
		//include:目前這隻程式 面對客戶，另外資訊由其他servlet來提供(Lisa10.java)
		
		out.print("<hr />");
		out.print("@copyright...");
		response.flushBuffer();
	}


}
