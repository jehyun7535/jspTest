package kr.or.ddit.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.EmpService;
import kr.or.ddit.user.service.EmpServiceI;

@WebServlet("/emp")
public class EmpController extends HttpServlet{
   
   private EmpServiceI empService = new EmpService();
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      int empno = Integer.parseInt(req.getParameter("empno"));
      
      EmpVo emp = empService.selectEmp(empno);
      
      req.setAttribute("emp", emp);
      
      req.getRequestDispatcher("/emp/emp.jsp").forward(req, resp);
   }
}