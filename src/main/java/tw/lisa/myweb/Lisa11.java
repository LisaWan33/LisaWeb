package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.lisa.api.Bike;


@WebServlet("/Lisa11")
public class Lisa11 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("Lisa12");
		
		request.setAttribute("key3", "33");
		request.setAttribute("key4", "77");
		
		Bike b1=new Bike();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		
		request.setAttribute("b1", b1);
		b1.downSpeed();
		System.out.println(b1.getSpeed());
		
		//-----------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("Hello,Lisa <br/>");
		out.print("<hr />");
		out.print("I'm Lisa11");
		
		dispatcher.forward(request, response);
		
		out.print("<hr />");
		out.print("@copyright...");
		
		response.flushBuffer();
	}


}
