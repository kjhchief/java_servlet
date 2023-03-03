package ezen.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigExample
 */
@WebServlet(
		urlPatterns = { "/config", "/config2" }, // 배열 
		initParams = { 
				@WebInitParam(name = "fileStorage", value = "c:/xxx/yyy")
		})
public class ServletConfigExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String fileStorage;
	@Override
	public void init(ServletConfig config) throws ServletException {
		fileStorage = config.getInitParameter("fileStorage");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(fileStorage);
	}

}
