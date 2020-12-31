package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

public class TimesTablesServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
	resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>Times tables Servlet</title>");
		pw.println("<style>");
		pw.println("table{width : 100%; text-align : center;}");
		pw.println("td{border : 1px solid black; }");
		pw.println("</style>");
		pw.println("	</head>");
		pw.println("  <body>");
		pw.println("<h1>servlet 구구단</h1>");
		pw.println("<table border='1'>");

		for(int i=1; i<=9; i++) {
			pw.println("  <tr>");
		
		for(int j = 2; j<10; j++) {
			pw.println("<td>" + i + " * " + j + " = " + i * j + "</td>");
		}
		pw.println("</tr>");
		}
				
		pw.println("</table>");
		pw.println("	</body>");
		pw.println("</html>");
		
	}


}
