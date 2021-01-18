<%@page import="org.apache.catalina.User"%>
<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/common/common_lib.jsp"%>

<!-- common_lib.jsp -->

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css"rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css"rel="stylesheet">

<script type="text/javascript">
	//문서 로딩이 완료되고 나서 실행되는 영역

	$(function() {
		$(".user").on("click", function() {
			//this : 클릭 이벤트가 발생한 element
			// data-속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
			// data-userId ==> data-userid
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
		});
	});
</script>

</head>

<body>

	<form id="frm" action="${pageContext.request.contextPath}/user">
		<input type="hidden" id="userid" name="userid" value="" />
	</form>

	<%@ include file="/common/header.jsp"%>

	<!-- header.jsp -->
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				left include
				<!-- left.jsp -->
				<%@ include file="/common/left.jsp"%>
			</div>

			<div class="container">
				<table class="table">
					<tr>
						<th>사용자아이디</th>
						<th>사용자이름</th>
						<th>사용자별명</th>
						<th>등록일시</th>
					</tr>

					<c:forEach items="${userList }" var="user">
						<tr>
							<td>${user.userid }</td>
							<td>${user.usernm }</td>
							<td>${user.alias }</td>
							<td>${user.getReg_dt_fmt() }</td>
						</tr>
					</c:forEach>
					
				</table>
				<a class="btn btn-default pull-right">사용자 등록</a>
			</div>

			<div class="text-center">

				<ul class="pagination">
					<li class="prev">
					<a	href="${pageContext.request.contextPath}/pagingUser?page=1&pageSize=${pageVo.pageSize}">«</a>
					</li>
					
					<c:forEach begin="1" end="${pagination}" var="i">
						<c:choose>
							<c:when test="${pageVo.page == i}">
								<li class="active"><span>${i}</span></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/pagingUser?page=${i}&pageSize=${pageVo.pageSize}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<li class="next">
					<a href="${pageContext.request.contextPath}/pagingUser?page=${pagination}&pageSize=${pageVo.pageSize}">»</a>
					</li>
					
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
