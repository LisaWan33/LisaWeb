<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="Lisa" %> <!-- 資料夾路徑 -->
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="iii" %> <!-- 讀檔 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<Lisa:test1 />
		<hr />
		<Lisa:test2 />
		<hr />
		
		<table border="1" width="100%">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr> 
			<Lisa:test3 name="Notebook" price="1000" />
			<Lisa:test3 name="Mouse" 	price="10" />
			<Lisa:test3 name="Camera" price="3000" />
			<Lisa:test3 name="iPhone" price="5000" />
		</table>
		<hr/>
		<iii:Lottery/>
		<hr />

		<iii:mytag2>
			brad<br>
			ok<br>
			1234567
		</iii:mytag2>
		<hr/>
		
		<Lisa:sayHello user="Lisa" />
		<Lisa:sayHello user="Tony" />
		<Lisa:sayHello user="Brad" />
		<Lisa:sayHello user="kevin" />
		<hr />
		
		<Lisa:calc x="10" y="3">
			10 + 3 =${plus }<br />
			10 - 3 =${sub }<br />
			10 x 3 =${multi }<br />
			10 / 3 =${divide }<br />
		</Lisa:calc>
	</body>
</html>