package tw.lisa.myweb;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lisa17")
public class Lisa17 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String source=
			"C:\\Users\\ACER\\Documents\\GitHub\\LisaWeb\\src\\main\\webapp\\imgs\\newcat.jpg";
		BufferedImage bimg=ImageIO.read(new File(source));
		
		Font font =new Font(null, Font.BOLD+Font.ITALIC, 48);
		AffineTransform tran =new AffineTransform();
		tran.rotate(Math.toRadians(-30)); //角度 degree =>弧度
		Font font2 =font.deriveFont(tran);
		
		
		
		Graphics2D g2d=bimg.createGraphics();
		g2d.setColor(Color.darkGray);
		g2d.setFont(font2);
		g2d.drawString("資展國際", 100, 200);
		
		
		//---------
		response.setContentType("imge/jpeg");
		OutputStream out= response.getOutputStream();
		ImageIO.write(bimg, "jpeg", out); //灌出去
		response.flushBuffer();
		
//		FileOutputStream fout=new FileOutputStream(
//		"C:\\Users\\ACER\\Documents\\GitHub\\LisaWeb\\src\\main\\webapp\\imgs\\newcat.jpg");
//		ImageIO.write(bimg, "jpeg", fout); //灌出去
//		fout.flush();
//		fout.close();
	}


}
