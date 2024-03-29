package tw.lisa.myweb;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lisa08")
public class Lisa08 extends HttpServlet {
 
    public Lisa08() {
    	System.out.println("Lisa08()");
    }

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service()1");
		super.service(req, res);
		System.out.println("service()2");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig)");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
