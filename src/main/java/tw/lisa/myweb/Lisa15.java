package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.lisa.api.LisaUtils;

@WebServlet("/Lisa15")
public class Lisa15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x= request.getParameter("x");
		String y= request.getParameter("y");
		Double r =(Double)request.getAttribute("result");
		String view =(String)request.getAttribute("view");
		
		
		String op1 = (String)request.getAttribute("op1");
		String op2 = (String)request.getAttribute("op2");
		String op3 = (String)request.getAttribute("op3");
		String op4 = (String)request.getAttribute("op4");
		
		String result;
		if(x!=null && y!=null) {
			result = r + "";
		}else {
			x = y= result = "";
		}
		
		//------------
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String content;
		try {
			content = LisaUtils.loadView("view"); //view2 (V2)
			out.printf(content ,x ,op1, op2, op3, op4, y, result);
			response.flushBuffer();
		} catch (Exception e) {
			out.print("ERROR");
			response.flushBuffer();
			}
	}
}
