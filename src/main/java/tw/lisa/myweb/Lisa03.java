package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lisa03")
public class Lisa03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//瀏覽器，預設字樣
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out =response.getWriter();
		out.print("Hello,World!<br/> \n"); //\n:原始碼換列
		
		out.print("Hello,World2!");
		response.flushBuffer(); //=>out.flush(); out.close();
	}

}
