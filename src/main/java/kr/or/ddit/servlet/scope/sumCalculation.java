package kr.or.ddit.servlet.scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);



	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/sumCalculation");
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		
		int start = Integer.parseInt(req.getParameter("start"));
		int end = Integer.parseInt(req.getParameter("end"));
		
		
		int sumResult = 0;
		for(int i = start; i <= end; i++) {
			sumResult = sumResult + i;
		}
		
		logger.debug("start:{}, end:{}", start, end);
		logger.debug("sumResult:{}", sumResult);
	
		
		int mul1 = Integer.parseInt(req.getParameter("mul1"));
		int mul2 = Integer.parseInt(req.getParameter("mul2"));
		
		int mulresult = 0;
		mulresult = mul1 * mul2;
		
		logger.debug("mul1:{}, mul2:{}", mul1, mul2);
		logger.debug("result:{}", mulresult);
		
		req.getSession().setAttribute("start", start);
		req.getSession().setAttribute("end", end);		
		req.getSession().setAttribute("sumResult", sumResult);
		
		req.getSession().setAttribute("mul1", mul2);
		req.getSession().setAttribute("mul2", mul2);		
		req.getSession().setAttribute("result", mulresult);
		
		req.getRequestDispatcher("jsp/sumResult.jsp").forward(req, res);

	}

}
