package kr.or.ddit.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.service.EmpService;
import kr.or.ddit.user.service.EmpServiceI;

@WebServlet("/deleteEmp")
public class EmpDelete extends HttpServlet{
	
	private EmpServiceI empService = new EmpService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno = Integer.parseInt(req.getParameter("empno"));
		
		int deleteCnt = 0;
		
		try {
			deleteCnt = empService.deleteEmp(empno);
		} catch (Exception e) {
			deleteCnt = -1;
		}
		if(deleteCnt ==1) {
			resp.sendRedirect(req.getContextPath() + "/pagingemp");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/emp?empno=" + empno);
		}
		
	}
}
