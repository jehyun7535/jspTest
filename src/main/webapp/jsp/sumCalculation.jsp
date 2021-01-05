<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "<%=request.getContextPath()%>/sumCalculation" method="post">
	<h1>첫번째 숫자 ~ 두번째 숫자 까지 더하기</h1>
		<input type ="text" name="start"/>에서 <br>
		<input type ="text" name="end"/>까지 합 <br><br>
	<h1>첫번째 숫자, 두번째 숫자 곱하기</h1>
		<input type ="text" name="mul1"/>*
		<input type ="text" name="mul2"/><br>
		<input type ="submit" value="입력"/>

	</form>
</body>
</html>