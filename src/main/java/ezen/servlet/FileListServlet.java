package ezen.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 업로드 파일 목록 조회
 */
@WebServlet("/listtt")
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String uploadPath = "c:/ezen-academy/fileStorage";
//	private String uploadPath;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>파일 목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>업로드 파일 목록</h2>");
		
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>번호</th><th>파일이름</th><th>파일크기</th>");
		out.println("</tr>");
		
		File directory = new File(uploadPath);
		File[] fileList = directory.listFiles();
		for (int i=0; i<fileList.length; i++) {
			File file = fileList[i];
			if(file.isFile()) {
				String fileName = file.getName();
				//long fileSize = file.length();
				int fileSize = (int)Math.ceil(file.length()/1024.0);
				out.println("<tr>");
				out.println("<td>"+(i+1)+"</td><td><a href='download?file="+fileName+"'>"+fileName+"</a></td><td>"+fileSize+"KB</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
	}
}











