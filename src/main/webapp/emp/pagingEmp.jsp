<%@page import="kr.or.ddit.user.model.EmpVo"%>
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

<script type="text/javascript">
//문서 로딩이 완료되고 나서 실행되는 영역

$(function() {
	$(".emp").on("click", function(){
		//this : 클릭 이벤트가 발생한 element
		// data-속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
		// data-userId ==> data-userid
		var empno = $(this).data("empno");
		$("#empno").val(empno);
		$("#frm").submit();
	});
});

</script>

</head>

<body>
	<form id="frm" action="<%=request.getContextPath() %>/emp" >
		<input type="hidden" id="empno" name="empno" value=""/>
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
						<th>사원</th>
						<th>사원이름</th>
						<th>담당역할</th>
						<th>매니저사번</th>
						<th>입사일자</th>
						<th>급여</th>
						<th>성과급</th>
						<th>소속부서번호</th>
					</tr>
					<%
					List<EmpVo> empList = (List<EmpVo>) request.getAttribute("empList");

					for (EmpVo vo : empList) {
					%>
					<tr class="emp" data-empno="<%=vo.getEmpno()%>">
						<td><%=vo.getEmpno()%></td>
						<td><%=vo.getEname()%></td>
						<td><%=vo.getJob()%></td>
						<td><%=vo.getMgr()%></td>
						<td><%=vo.getHiredate_fmt()%></td>
						<td><%=vo.getSal()%></td>
						<td><%=vo.getComm()%></td>
						<td><%=vo.getDeptno()%></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
			<a class="btn btn-default pull-right">사용자 등록</a>

			<div class="text-center">
				<ul class="pagination">
					<%
					int j = 0;
					j = (int)request.getAttribute("pagination");
					for (int i = 1; i<j+1; i++) { 
					%>
				<li><a href="<%=request.getContextPath() %>/pagingemp?page=<%=i%>&pageSize=5"><%=i%></a></li>
				<%
					}
				%>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
