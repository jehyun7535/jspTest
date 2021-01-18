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

@WebServlet("/registEmp")
public class RegistEmp extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(RegistEmp.class);
	private EmpService empService = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/emp/registEmp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("reg dopost 진입");
		req.setCharacterEncoding("UTF-8");

		int empno = Integer.parseInt(req.getParameter("empNo"));
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		int sal = Integer.parseInt(req.getParameter("sal"));
		int mgr = Integer.parseInt(req.getParameter("mgr"));
		int comm = Integer.parseInt(req.getParameter("comm"));
		int deptno = Integer.parseInt(req.getParameter("deptno"));

		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		Date hiredate = new Date();
		
//		try {
//			hiredate = sdf.parse(req.getParameter("hiredate"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		EmpVo empVo = new EmpVo(empno, ename, job, hiredate, mgr, sal, comm, deptno);
		logger.debug("ev : {}", empVo);
		
		int registCnt = 0;
		try {
			registCnt = empService.registEmp(empVo);
			logger.debug("ok? {}",registCnt);
			// 사용자 수정이 정상적으로 된 경우 ==> 해당 사용자의 상세조회 페이지로 이동
			if (registCnt == 1) {

				// doGet(req,resp); doGet에 userid값을 받아오기 때문에 가능
				resp.sendRedirect(req.getContextPath() + "/emp?empno=" + empno);
			}
		} catch (Exception e) {
			doGet(req, resp);
		}

	}
}
