package ezen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그인 처리 서블릿
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId= request.getParameter("id");
		String loginPw= request.getParameter("password");
		
		// 사용자 테이블을 조회하여 사용자인증 처리
		boolean isMember = true;
		
		if(isMember) {
			// 사용자 로그인 아이디를 브라우저 세션에 저장
			// 서버쪽의 사용자 정보를 저장하기 위한 장부
			HttpSession session = request.getSession();
			// 클라이언트에 해당하는 HttpSession 객체 존재 시 HttpSession 객체 반환하고,
			// 존재하지 않을 경우 새로운 HttpSession 생성하여 반환
//			HttpSession session = request.getSession(true);
			
			System.out.println(session);
			session.setAttribute("loginId", loginId);
			session.setAttribute("item", "TV");
			
			
			response.sendRedirect("main");
		}
		
		System.out.println(loginId);
		System.out.println(loginPw);
	}

}
