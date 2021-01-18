<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	text-align: center;
}
</style>
</head>
<body>
	<h2>표현식, 스크립틀릿을 EL,JSTL로 변경</h2>
	<table border="1">
	<%-- 
	
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
		
		--%>
		<c:forEach begin="2" end="9" var="i" varStatus="loop">
			<tr>
				<c:forEach begin="1" end="9" var="j" varStatus="loop">
					<td>${i}* ${j} = ${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>	
	</table>
	
	<h3>향상된 for 문 형태</h3>
	
	<%
		//반복시킬 데이터 준비
		List<String> rangers = new ArrayList<String>();
			rangers.add("brown");
			rangers.add("cony");
			rangers.add("sally");
			rangers.add("moon");
			rangers.add("james");
			request.setAttribute("rangers", rangers);
			
		/*
			for(String ranger : (List<String>request.getAttribute("rangers")) ){
				
			}
			
			<c:forEach items="${rangers}" var="ranger">
			</c:forEach>
		*/
			
	%>
	
		<c:forEach items="${rangers}" var="ranger" >
			${ranger}  <br>
		</c:forEach>

		
</body>
</html>