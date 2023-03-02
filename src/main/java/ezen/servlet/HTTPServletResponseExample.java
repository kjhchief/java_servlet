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
 * HTTPServletRequest가 제공하는 주요 메소드(기능
 */
@WebServlet("/response")
public class HTTPServletResponseExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("audio/mpeg");
		response.setContentType("application/pdf"); // pdf
		String path ="C:/ezen-academy/workspace/java_servlet/src/main/fileStorage/Git & GitHub.pdf";
		InputStream in = new FileInputStream(path);
		OutputStream out = response.getOutputStream();
		
		int count = 0;
		byte[] buffer = new byte[1024];
		while((count= in.read(buffer)) != -1) {
			out.write(buffer, 0, count);
		}
		
		in.close();
		out.close();
		
	}

}
