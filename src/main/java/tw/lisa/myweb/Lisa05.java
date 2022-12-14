package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lisa05")
public class Lisa05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String x  = request.getParameter("x");	
	String y  = request.getParameter("y");
	String op = request.getParameter("op");
	String r  = "";
	
	if(x!=null && y!=null){ 
		int intx=0; int inty=0;
	
		try {
			intx =Integer.parseInt(x);
		}catch (Exception e) {}
			
		try{
			inty =Integer.parseInt(y);
		}catch (Exception e) {}
		
		int result;
		switch(op) {
		case "1": result =intx + inty; r += result; break;
		case "2": result =intx - inty; r += result; break;
		case "3": result =intx * inty; r += result; break;
		case "4": 
			result =intx / inty; 
			r += result+"...."+ (intx % inty);
			break;
		}
	}else{
		x=y=op= "";
	}
	
	//---------去ㄎ一ㄤ Lisa04.html 資料-----------
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out =response.getWriter();
	out.print("<form action='Lisa05'>");
	out.printf("<input name='x' value='%s' />",x);
	
	out.print("<select name='op'> ");
	out.print("<option value='1' "+
			(op.equals("1")?"selected":"") + "> + </option>");
	
	out.print("<option value='2' "+
			(op.equals("2")?"selected":"") + "> - </option>");
	
	out.print("<option value='3' "+
			(op.equals("3")?"selected":"") + "> x </option>");
	out.print("<option value='4'"+
			(op.equals("4")?"selected":"") + "> / </option>");
	out.print("</select>");
	
	out.printf("<input name='y'/ value='%s' />", y);
	out.print("<input type='submit' value='='>");
	out.printf("<span> %s </span>",r);
	out.print("</form>");
	
	response.flushBuffer();
	}
}
