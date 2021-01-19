<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/common_lib.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function select(){
	
}
</script>
</head>
<body>
<select id="select" name="select">
	<option value="kor">한국어</option>
	<option value="eng">english</option>
	<option value="jap">日本語</option>
	<option value="git">기타</option>		
</select>

<%--select box로 설정한 언어로 GREETING, LANG 값을 표현 
	select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정--%>
<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG" />	<br>
		<fmt:message key="GREETING">
			<fmt:param value="brown" />
		</fmt:message> <br>
	</fmt:bundle>
<br>
  <input type="submit" value="전송">
</body>
</html>