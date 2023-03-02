package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTTPServletRequest가 제공하는 주요 메소드(기능
 */
@WebServlet("/request")
public class HTTPServletRequestExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		
		String clientIP = request.getRemoteAddr();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<ul>");
		out.println("<li>클라이언트 아이피: " + clientIP + "</li>");
		// 요청메세지의 요청라인 정보
		out.println("<li>클라이언트 요청방식: " + request.getMethod() + "</li>");
		out.println("<li>클라이언트 요청URI: " + request.getRequestURI() + "</li>");
		out.println("<li>클라이언트 요청PROTOCOL: " + request.getProtocol() + "</li>");
		// 요청헤더 정보
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			out.println("<li>"+name+": "+value+"</li>");
			
		}
		
		// Context Path
		out.println("<li>컨텍스트 패스: "+request.getContextPath()+"</li>");
		
		out.println("</ul>");
 		
		out.println("</body>");
		
		
		out.println("</html>");
		
	}

}
