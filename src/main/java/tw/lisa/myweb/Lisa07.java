package tw.lisa.myweb;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Lisa07") //2
@MultipartConfig(
		location="C:\\Users\\ACER\\Documents\\GitHub\\LisaWeb\\src\\main\\webapp\\upload"
		)

public class Lisa07 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String urIp = request.getRemoteAddr();
//		Part part = request.getPart("upload");
//		part.write(urIp +".jpg");
		int i=0;
		Collection<Part> parts=request.getParts();
		for(Part part: parts) {
			String name=part.getName();
			String type=part.getContentType();
//			System.out.printf("%s , %s\n",name,type);
			
			if(type !=null) {
				String[] temp= type.split("/");
				String fname= part.getSubmittedFileName();
				String sname= "." +temp[1];
				long size = part.getSize();
				System.out.printf("file=> %s : %s :%d\n",temp[0],fname,size);
				
				if(size>0) {
					
					if(temp[0].equals( "application" )) {
						if(fname.contains(".")) {
							String[] wname=fname.split("\\.");
							sname=wname[wname.length-1];
						}else {
							sname="";
						}
					}
					
					String saveName=urIp+ "_"+ ++i +"_" +sname;
					System.out.println(saveName+"\n");
					part.write(saveName);
//					part.write(urIp+ "_"+ ++i +sname);
				}
			}
		}
	}

}