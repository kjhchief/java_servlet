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

/**
 * 최초로 만든 서블릿
 * 동적 컨텐츠(html, css, javascript) 생성
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저에게 서비스 하는 데이터 출력
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		// 동적 콘텐츠 출력
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h1>점심 먹으러 갑시다.</h1>");
		
		Calendar today = Calendar.getInstance();
		String ymd = String.format("%1$tF %1$tT", today);
		
		out.println("<p>현재시간 : "+ymd+"</p>");
		out.println("<h1>점심 먹으러 갑시다.</h1>");
		
		// 구구단 출력
		ServletContext servletContainer = getServletContext();
		RequestDispatcher dispatcher = servletContainer.getRequestDispatcher("/gugudan");
		dispatcher.include(request, response);
		
		System.out.println(servletContainer.getContextPath()); // 이게 컨테이너 이름이라고 생각하면 됨
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
