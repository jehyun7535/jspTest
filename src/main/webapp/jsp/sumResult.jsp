<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "<%=request.getContextPath() %>/sumCalculation" method="post">
 	결과값: <%=session.getAttribute("sumResult") %> <br>
 	곱셈 결과값: <%=session.getAttribute("result") %>
	</form>
</body>
</html>