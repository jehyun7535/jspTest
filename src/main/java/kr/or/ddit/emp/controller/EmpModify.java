package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.EmpService;

@WebServlet("/empModify")
public class EmpModify extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(EmpModify.class);
	private EmpService empService = new EmpService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno = Integer.parseInt(req.getParameter("empno"));
		EmpVo emp = empService.selectEmp(empno);
		req.setAttribute("emp", emp);
		
		req.getRequestDispatcher("/emp/empModify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		
		int empno = Integer.parseInt(req.getParameter("empno"));
		String ename= req.getParameter("ename");
		String job = req.getParameter("job");
		int mgr = Integer.parseInt(req.getParameter("mgr"));
		int sal = Integer.parseInt(req.getParameter("sal"));
		int comm = Integer.parseInt(req.getParameter("comm"));
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date hiredate = null;
		try {
			hiredate = sdf.parse(req.getParameter("hiredate"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EmpVo empVo = new EmpVo(empno, ename, job, hiredate, mgr, sal, comm, deptno);
	
		int updateCnt = empService.modifyEmp(empVo);
		
		if(updateCnt == 1) {
			
			resp.sendRedirect(req.getContextPath()+"/emp?empno="+empno);
		}
		else {
			doGet(req, resp);
		}
	}
}
