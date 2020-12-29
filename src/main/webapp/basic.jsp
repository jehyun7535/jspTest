<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ %> : 지시자-jsp페이지에 대한 설정정보 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Date date = new Date(); %> <%--스크립틀릿 : 자바 코드를 작성 --%> 
	Hello, World <%=new Date() %> <%--표현식 : 문자열 출력 --%>
</body>
</html>

<%--
	jsp 구성요서
	1. 지시자 : page의 설정 정본
	2. 스크립틀릿 : java 코드 ==> JSTL(Java Standard Tag Library) 
	3. 표현식 : 문자열로 출력 ==> EL(Expression Language, 표현언어)
	4. 주석 
	5. 선언부 : 변수나 method 선언, 
	jsp는 화면 컨텐츠를 생성하는 역할
	변수나 method는 로직 처리시 주로 사용
 --%>