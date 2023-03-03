package ezen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 브라우저의 요청을 처리하는 프론트 컨트롤러 역할의 서블릿
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null) {
			command = "default";
			
		}
		
		ServletContext context = getServletContext(); // 현재 서블릿을 실행하는 서블릿 컨테이너 얻기
		RequestDispatcher dispatcher = null; 
				
		
		switch (command) {
		case "writer": // 게시판 글쓰기 요청
			dispatcher = context.getRequestDispatcher("/board/writer.html");
			dispatcher.forward(request, response);
			break;
		case "join": // 회원 가입 요청
			dispatcher = context.getRequestDispatcher("/member/userForm.html");
			dispatcher.forward(request, response);
			break;

		default:
			dispatcher = context.getRequestDispatcher("/index.html");
			dispatcher.forward(request, response);
			break;
		}
		
		
	}

}
