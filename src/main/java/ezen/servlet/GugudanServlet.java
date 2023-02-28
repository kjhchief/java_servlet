package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 구구단을 동적으로 생성해서 서비스하는 서블릿
 */
// 서블릿을 서블릿 컨테이너에 등록(deploy) 할 때 방법 2
// 패스형식
@WebServlet("/gugudan")
// 확장자 형식
//@WebServlet("xxx/yyy/gugudan.action")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// doGet 호출은? 서블릿 컨테이너가 알아서 메모리에 생성함. 알아서 호출함. 근데 쓰레드로.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestMethod = request.getMethod();
		String requestUri = request.getRequestURI();
		String protocol = request.getProtocol();
		System.out.println("브라우저 요청 방식: "+requestMethod);
		System.out.println("브라우저 요청 URI: "+requestUri);
		System.out.println("브라우저 요청 프로토콜: "+protocol);
		
		// JDBC 이용하여 Database 연결 및 데이터수신(나중에)
		String title = "데이터베이스에 저장된 데이터";
		
		// 브라우저에게 서비스 하는 데이터 동적 출력
		// 응답 메세지 헤더에 Content-Type: text/html; charset=utf8 설정
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 동적 콘텐츠 출력
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("게시판 타이틀 : " + title);
		
		out.println("<table border='1' style='color:blue'>");
		
		for (int i = 2; i <= 9; i++) {
			out.println("<tr>");
			for(int j=1; j <=9; j++) {
				out.println("<td>"+i+" * "+j+" ="+(i*j)+"</td>");
				
			}
			out.println("</tr>");
			
		}
		out.println("</td>");
		
		out.println("</table>");
		
		
		out.println("</body>");
		
		
		out.println("</html>");
	}

}
