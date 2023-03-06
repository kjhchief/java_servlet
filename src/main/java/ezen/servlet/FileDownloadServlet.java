package ezen.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 파일 다운로드
 */
@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String uploadPath = "c:/ezen-academy/fileStorage";
//	private String uploadPath;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        process(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파라메터로 넘어오는 파일이름 얻기 
    	String fileName = request.getParameter("file");
        String filePath = uploadPath + File.separator + fileName;
        File file = new File(filePath);
        
        // 파일 존재시
        if(file.exists()) {
        	// 브라우저 캐시 사용 않도록 응답헤더 설정
            response.setHeader("Cache-Control", "no-cache");
            // 파일 다운로드 처리를 위한 응답헤더에 마임타입 설정
            response.setContentType("application/octet-stream; charset=utf-8");
            fileName = URLEncoder.encode(fileName, "utf-8");
            // Content-Disposition 헤더 설정
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
            // Content-Length 헤더 설정
            response.setHeader("Content-Length", String.valueOf(file.length()));
            FileInputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            try{
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = in.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
            }catch (Exception e) {
				e.printStackTrace();
			}finally{
                if(out != null) out.close();
                if(in != null)  in.close();
            }
        }else { // 파일이 없을 경우
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<h3>" + fileName + "파일이 존재하지 않습니다.</h3>");
        }
    }
}

