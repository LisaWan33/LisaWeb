package tw.lisa.myweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.lisa.api.BCrypt;
@WebServlet("/Lisa20")
public class Lisa20 extends HttpServlet {
	private Connection conn=null;
	private static final int CHECK_OK=1;
	private static final int CHECK_EXCEPTION=2;
	private static final int CHECK_ACCOUNT_ERROR=3;
	private static final int CHECK_PASSWD_ERROR=4;
	
	//可以連接JDBC12的應用連接sql
	public Lisa20() {
		Properties prop= new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("ok");
			conn= DriverManager.getConnection(
					"jdbc:mysql://localhost:3309/eeit53",prop);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.service(req, resp);
		
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		int check = checkAccount(account, passwd);
		
		switch(check) {
			case CHECK_OK:
				response.sendRedirect("Lisa21.html");
				break;
			case CHECK_ACCOUNT_ERROR:
				response.sendRedirect("Lisa20.html");
				System.out.println("帳號錯誤");
				break;
			case CHECK_PASSWD_ERROR:
				response.sendRedirect("Lisa20.html");
				System.out.println("密碼錯誤");
				
				break;
			case CHECK_EXCEPTION:
				response.sendRedirect("Lisa20.html");
				System.out.println("例外錯誤");

				break;
		}
		
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		
//		String account= request.getParameter("account");
//		String passwd= request.getParameter("password");
//		int check =checkAccount(account,passwd);
//		
//		switch(check) {
//			case CHECK_OK:
//				response.sendRedirect("Lisa21.html");//告知輸入正確，到welcome畫面
//				break;
//				
//			case CHECK_ACCOUNT_ERROR:
//	//			response.sendRedirect("Lisa20.html");//告知輸入錯誤，回退原本畫面
//	//			break;
//				
//			case CHECK_PASSWD_ERROR:
//	//			response.sendRedirect("Lisa20.html");//告知輸入錯誤，回退原本畫面
//	//			break;
//				
//			case CHECK_EXCEPTION:
//				response.sendRedirect("Lisa20.html");//告知輸入錯誤，回退原本畫面
//				break;
//			
//			}
//	}
	
	private int checkAccount(String account, String passwd) {
		String sql ="SELECT * FROM member WHERE account= ?";
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String passwdHash=rs.getString("password");
				if(BCrypt.checkpw(passwd, passwdHash)) {
					return CHECK_OK;
				}else {
					return CHECK_PASSWD_ERROR;
				}
			}else {
				//沒找到
				return CHECK_ACCOUNT_ERROR;
			}
		} catch (SQLException e) {
			//例外情況
			return CHECK_EXCEPTION;
		}
	}
}
