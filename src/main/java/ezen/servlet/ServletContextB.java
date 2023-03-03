package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletContextA
 */
@WebServlet("/b")
public class ServletContextB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String message = (String)getServletContext().getAttribute("message");
//		Calendar today = (Calendar)getServletContext().getAttribute("today");
		
//		String message = (String) request.getAttribute("message");
//		Calendar today = (Calendar) request.getAttribute("today");
//		
//		System.out.println(message);
//		System.out.println(today);
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>"+id+"님 반갑습니다...</h2>");
		out.println("게시판 내용 입니다.");
		out.println("</body>");
		out.println("</html>");
	}

}
