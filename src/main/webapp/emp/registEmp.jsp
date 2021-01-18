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
				
				<form class="form-horizontal" role="form" method="post" action="<%=request.getContextPath()%>/registEmp">
					<input type="hidden" name="empno" value=""/>
					
					<div class="form-group">
						<label class="col-sm-2 control-label"> 사원번호</label>
							<div class="col-sm-10">
							<% String empno = request.getParameter("empno");
							empno = empno == null ? "" : empno;%>
							<label><input type="text" id="empNo" name="empNo" 
							placeholder="사원번호" value = "<%=empno%>" class="form-control"></label>
						</div>
					</div>

					<div class="form-group">
						<label for="usernm" class="col-sm-2 control-label">사원이름</label>
						<div class="col-sm-10">
							<% String ename = request.getParameter("ename");
								ename = ename == null ? "" : ename;%>						
							<input type="text" class="form-control" id="ename" name="ename"
								placeholder="사원이름" value="<%=ename%>"/>
						</div>
					</div>
					
					
								
					
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">담당역할</label>
						<div class="col-sm-10">
							<% String job = request.getParameter("job");
								job = job == null ? "" : job;%>						
							<input type="text" class="form-control" id="job" name="job"
								placeholder="담당역할" value="<%=job%>"/>
						</div>
					</div>
		

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">매니저사번</label>
						<div class="col-sm-10">
							<% String mgr = request.getParameter("mgr");
								mgr = mgr == null ? "" : mgr;%>						
							<input type="text" class="form-control" id="mgr" name="mgr"
								placeholder="매니저사번" value="<%=mgr%>"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">입사일자</label>
						<div class="col-sm-10">
							<% String hiredate = request.getParameter("hiredate");
								hiredate = hiredate == null ? "" : hiredate;%>							
							<input type="text" class="form-control" id="hiredate" name="hiredate"
								placeholder="등록일시 자동생성" value="<%=hiredate%>" readonly>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">급여</label>
						<div class="col-sm-8">
								<% String sal = request.getParameter("sal");
								sal = sal == null ? "" : sal;%>						
							<input type="text" class="form-control" id="sal" name="sal"
								placeholder="급여" value="<%=sal %>">
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">성과급</label>
						<div class="col-sm-10">
							<% String comm = request.getParameter("comm");
								comm = comm == null ? "": comm;%>						
							<input type="text" class="form-control" id="comm" name="comm"
								placeholder="상세주소" value="<%=comm%>"/>
						</div>
					</div>

					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">소속부서번호</label>
						<div class="col-sm-10">
							<% String deptno = request.getParameter("deptno");
								deptno = deptno == null ? "" : deptno;%>						
							<input type="text" class="form-control" id="deptno" name="deptno"
								placeholder="소속부서번호" value="<%=deptno %>">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>