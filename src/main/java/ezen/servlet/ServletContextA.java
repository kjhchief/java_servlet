package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 */
@WebServlet("/a")
public class ServletContextA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB 특정 테이블에서 데이터 조회
//		String message = "서블릿 데이터 공유하기";
//		Calendar today = Calendar.getInstance();
		ServletContext ctx = getServletContext();
//		ctx.setAttribute("message", message);
//		ctx.setAttribute("today", today);
		
//		request.setAttribute("message", message);
//		request.setAttribute("today", today);
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// DB 회원테이블로부터 회원인지 여부 체크
		// 편의상 회원이라 가정
		HttpSession session = request.getSession(); 
		session.setAttribute("id", id );
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>"+id+"님 반갑습니다...</h2>");
		
		out.println("</body>");
		out.println("</html>");
		
		
		
//		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/b");
//		dispatcher.forward(request, response);
		
	}

}
