package ezen.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그인 처리 서블릿 => 쿠키를 넣자.
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
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
	*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("password");
		String saveId = request.getParameter("saveid");
		
		// 사용자 테이블을 조회하여 사용자인증 처리
		boolean isMember = true;
		
		if(isMember) {
			// 사용자 로그인 아이디를 브라우저 세션에 저장
			// 서버쪽의 사용자 정보를 저장하기 위한 장부
			
			// 쿠키를 이용하여 사용자 로그인 아이디 저장
			Cookie loginIdCookie = new Cookie("loginId", loginId);
			loginIdCookie.setPath("/"); // 모든 웹 애플리케이션 영역에서 사용 가능하도록 설정
			if(saveId != null) {
				loginIdCookie.setMaxAge(60*60*24*100); // 100일 동안 파일로 저장
			}
			response.addCookie(loginIdCookie);
			
//			String itemValue = "삼송 TV";
//			itemValue= URLEncoder.encode(itemValue, "utf-8");
			
			Cookie itemCookie = new Cookie("item", URLEncoder.encode("삼송 TV", "utf-8"));
			itemCookie.setPath("/");
			response.addCookie(itemCookie);
			
			response.sendRedirect("main");
		}
		
		System.out.println(loginId);
		System.out.println(loginPw);
	}

}
