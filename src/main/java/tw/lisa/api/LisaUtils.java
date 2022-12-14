package tw.lisa.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LisaUtils {
	public static String loadView( String view) throws Exception{
		
		String viewFile=String.format(
				"C:\\Users\\ACER\\Documents\\GitHub\\LisaWeb\\src\\main\\webapp\\views\\%s.html", view);
		
		File source= new File(viewFile);
		StringBuffer sb =new StringBuffer();
		
		FileReader fin=new FileReader(source);
		BufferedReader reader=new BufferedReader(fin);
		String line = null;
		while((line = reader.readLine() )!=null) {
			sb.append(line);
		}
		
		return sb.toString();
		//撰寫工具，被Lisa15叫
	}
	public static String sayYa() {
		return "Ya";
	}
	public static String sayYa(String name) {
		return String.format("Ya,%s<br />", name);
	}
	
	
	public static String calc(String x,String y, String op) {
		try {
				int intX=Integer.parseInt(x);
				int intY=Integer.parseInt(y);
				int r=0,mod=0;
				String ret ="";
				switch(op) {
				case "1":
					r =intX + intY; ret =r+""; break;
				case "2":
					r =intX - intY; ret =r+""; break;
				case "3":
					r =intX * intY; ret =r+""; break;
				case "4":
					r =intX / intY; mod = intX % intY ;ret =r + "..." + mod ; break;
				}
				return ret;
	}catch(Exception e) {
		return "";
	}
}
	public static int createScore() {
	 return (int)(Math.random()*101);
}
	
	public static int nextPage(String page, String pages) {
		int intPages = (int)Double.parseDouble(pages);
		int intPage = Integer.parseInt(page);
		return intPage >= intPages ? intPage : intPage + 1; 
	}
	
	public static String encPasswd(String passwd) {
		return BCrypt.hashpw(passwd, BCrypt.gensalt());
	}
}