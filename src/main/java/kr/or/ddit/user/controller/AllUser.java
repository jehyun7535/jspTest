package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@WebServlet("/alluser")
public class AllUser extends HttpServlet{
	   
	   private UserService userService = new UserService();
	   @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   req.setCharacterEncoding("UTF-8");
		   
	   List<UserVo> userList = userService.selectAllUser();

	   req.setAttribute("userList", userList);
	   
	   req.getRequestDispatcher("/user/allUser.jsp").forward(req, resp);
	   
	   }
}
