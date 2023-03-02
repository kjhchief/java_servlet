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
 * 회원가입 처리 서블릿
 */
@WebServlet("/member/register")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	// 브라우저 요청 방식에 상관없이 데이터를 수신
	// HOOK 메소드. 훅훅~~
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 전달된 데이터 수신 : 빠르나 보안 취약
		// POST방식으로 전달... : 보안 좋음
		// 폼 데이터로 전송되는 데이터중에 한글이 포함된 경우 
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		String name = request.getParameter("name");
//		String hobby = request.getParameter("hobby");
		// 동일한 이름의 파라미터에 여러개의 값이 전달되는 경우
		String[] hobbyValues = request.getParameterValues("hobby");
		if(hobbyValues !=null) {
			// 유효성 검증
		}
		
		for (String hobby : hobbyValues) {
			System.out.println(hobby);
		}
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		
		// 폼 태그의 이름을 알 수 없는 경우
		// DOM이 동적 생성된 경우
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String parameterName = e.nextElement();
			String parameterValue = request.getParameter(parameterName);
				
			System.out.println(parameterName + " : " + parameterValue);				
					
		}
					
			
			
			
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		
		out.println("<body>");
	
 		
		out.println("</body>");
		
		
		out.println("</html>");
		
	}

}
