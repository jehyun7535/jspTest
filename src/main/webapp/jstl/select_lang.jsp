<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_lib.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("select").on("change", function(){
		$("form").submit();
	})
	$("select").val("${param.lang}");
})
</script>
</head>
<body>

<%--select box로 설정한 언어로 GREETING, LANG 값을 표현
    select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정 --%>
param : [${param.lang}]
<form action="${pageContext.request.contextPath}/jstl/select_lang.jsp">
<select name="lang">
	<option value="kr">한국어</option>
	<option value="en">english</option>
	<option value="ja">日本語</option>
	<option value="etc">기타</option>
</select>
<!-- 	<input type="submit" value="전송"/> -->
</form>
<br><br>

<fmt:setLocale value="${param.lang}"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/>	<br>
	<fmt:message key="GREETING">
		<fmt:param value="brown"/>
	</fmt:message> <br>
</fmt:bundle>

</body>
</html>


