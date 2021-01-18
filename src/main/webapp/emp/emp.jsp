<%@page import="kr.or.ddit.user.service.EmpService"%>
<%@page import="kr.or.ddit.user.model.EmpVo"%>
<%@page import="kr.or.ddit.common.model.PageVo"%>
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

<title>Jsp</title>

<%@ include file="/common/common_lib.jsp"%>

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$(function() {
	$("#modifyBtn").on("click", function(){
		$("#frm").attr("method", "get");
		$("#frm").attr("action", "<%=request.getContextPath()%>/empModify");
		$("#frm").submit();
	});
})
</script>
</head>

<body>
	
	
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
				<% EmpVo emp = (EmpVo)request.getAttribute("emp"); %>
				
				<form class="form-horizontal"  id="frm" role="form">
					<input type="hidden" name=empno value="<%=emp.getEmpno() %>"/>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">사번</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getEmpno() %></label>
						</div>
					</div>

					<div class="form-group">
						<label for="usernm" class="col-sm-2 control-label">사원이름</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getEname() %></label>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">담당역할</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getJob() %></label>
						</div>
					</div>
		

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">매니저사번</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getMgr()%></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">입사일자</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getHiredate_fmt() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">급여</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getSal() %></label>
						</div>
					</div>

					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">성과급</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getComm() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">소속부서번호</label>
						<div class="col-sm-10">
							<label class="control-label"><%=emp.getDeptno() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="modifyBtn" class="btn btn-default">사용자 수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>