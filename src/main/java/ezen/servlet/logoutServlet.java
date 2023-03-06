package ezen.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그인 처리 서블릿
 */
@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 로그아웃 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		// 세션 삭제
//		session.invalidate();
		
		// 쿠키 정보 읽기
		Cookie[] cookies= request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if(cookieName.equalsIgnoreCase("loginId")) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
				
			}
		}
		
		response.sendRedirect("main");
		
		
	}

}
