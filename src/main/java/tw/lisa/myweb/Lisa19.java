package tw.lisa.myweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lisa19")
public class Lisa19 extends HttpServlet {
	private Connection conn=null;
	public Lisa19() {
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("ok");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3309/eeit53",prop);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(conn == null) return;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		try {
			Statement stmt =conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT name,city,town From food");
			out.print("<table border='1'>");
			while(rs.next()) {
//				System.out.println(rs.getString(1));
				out.print("<tr>");
				out.printf("<tr><td>%s</td></tr>",rs.getString("name"));
				out.printf("<tr><td>%s</td></tr>",rs.getString("city"));
				out.printf("<tr><td>%s</td></tr>",rs.getString("town"));
				out.print("<tr>");
			}
			out.print("<table>");
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}


}
