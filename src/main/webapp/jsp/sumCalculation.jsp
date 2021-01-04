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
		<input type ="text" name="start"/>에서 <br>
		<input type ="text" name="end"/>까지 합 <br>

	</form>
</body>
</html>