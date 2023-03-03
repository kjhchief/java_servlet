package ezen.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시판 글쓰기 서블릿
 */
@WebServlet("/board/writer")
public class BoardWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		System.out.println(writer);
		System.out.println(title);
		// DB 테이블 인서트 했다고 가정
		
		System.out.println("게시판 글쓰기 서블릿 요청");
		
		// 게시판 목록을 보여주는 서블릿으로 자동 요청처리(디스패치)
		// response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);//302
		// response.setHeader("Location", "/board/list");
		response.sendRedirect("list");
		
	}

}
