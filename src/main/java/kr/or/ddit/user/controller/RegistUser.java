package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@WebServlet("/registUser")
public class RegistUser extends HttpServlet {
private static final Logger logger = LoggerFactory.getLogger(RegistUser.class);
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);

	}

	// 사용자 정보 수정 요청 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터를 읽기 전에 실행
		// servlet의 doPost 메소드 마다 실행 필요 ==> Filter
//		req.setCharacterEncoding("UTF-8");
//		logger.debug("java {}");
		String userid = req.getParameter("userId");
		String usernm = req.getParameter("usernm");
		String pass = req.getParameter("pass");
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//		Date reg_dt = null;
//		//타입 변환
//		try {
//			reg_dt = sdf.parse(req.getParameter("reg_dt"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Date reg_dt = new Date();
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		UserVo userVo = new UserVo(userid, usernm, alias, reg_dt,
				pass, addr1, addr2, zipcode);
		
			int registCnt = 0;
		try {
			registCnt = userService.registUser(userVo);
			// 사용자 수정이 정상적으로 된 경우 ==> 해당 사용자의 상세조회 페이지로 이동
			if(registCnt == 1) {
				
				//doGet(req,resp); doGet에 userid값을 받아오기 때문에 가능
				resp.sendRedirect(req.getContextPath()+"/user?userid="+userid);
			}
		}
		 catch (Exception e) {
			doGet(req, resp);
		 }
		
//		
//		int registCnt = userService.registUser(userVo);
//		 사용자 수정이 정상적으로 된 경우 ==> 해당 사용자의 상세조회 페이지로 이동
//		if(registCnt == 1) {
//			doGet(req,resp); doGet에 userid값을 받아오기 때문에 가능
//			resp.sendRedirect(req.getContextPath()+"/user?userid="+userid);
//			
//		}
//		 사용자 수정이 비정상적으로 된 경우 ==> 해당 사용자의 정보 수정 페이지로 이동
//		else {
//			doGet(req, resp);
//		}
	}
}
