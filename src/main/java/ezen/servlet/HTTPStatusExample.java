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
 * 응답코드 강제 설정
 */
@WebServlet("/status")
public class HTTPStatusExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		if(id.equals("bangry")) {
			// 블랙리스트
//			response.sendError(403);
			response.sendError(HttpServletResponse.SC_FORBIDDEN);			
		}else {
			out.println("입장하세요");
		}
		
	}

}
