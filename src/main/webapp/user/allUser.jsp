<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
</head>

<body>

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
					<%
					List<UserVo> userList = (List<UserVo>) request.getAttribute("userList");

					for (UserVo vo : userList) {
					%>
					<tr>
						<td><%=vo.getUserid()%></td>
						<td><%=vo.getUsernm()%></td>
						<td><%=vo.getAlias()%></td>
						<td><%=vo.getReg_dt()%></td>
					</tr>

					<%
					}
					%>
				</table>
			</div>
			<a class="btn btn-default pull-right">사용자 등록</a>

			<div class="text-center">
				<ul class="pagination">
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
