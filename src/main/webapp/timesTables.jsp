<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
	width:100%;
	text-align: center;
	}
</style>
</head>
<body>

<h1>TimesTablesServlet를 jsp로 변환한 구구단 프로그램</h1>
	<table border="1">
		<%
		for (int i = 2; i < 10; i++) {
		%>
		<tr>
			<%
			for (int j = 1; j < 10; j++) {
			%>
			<td><%=i + " * " + j + " = " + i * j%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>