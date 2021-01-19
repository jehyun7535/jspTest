package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.EmpService;

@WebServlet("/allemp")
public class AllEmp extends HttpServlet{
	   
	   private EmpService empService = new EmpService();
	   @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 req.setCharacterEncoding("UTF-8");
		   
	   List<EmpVo> empList = empService.selectAllEmp();

	   req.setAttribute("empList", empList);
	   
	   req.getRequestDispatcher("/emp/allEmp.jsp").forward(req, resp);
	   
	   }
}
