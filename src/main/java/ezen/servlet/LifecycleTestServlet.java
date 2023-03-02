package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 컨테이너에 의해 생성되고 관리되는 서블릿의 생명주기 확인
 * 핵심 컨셉 : IOC (Inversion of Control) 
 */
@WebServlet("/lifecycle")
public class LifecycleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;
	
	// DB 연결정보 상수
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle
	private static final String user = "hr";
	private static final String password = "hr";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifecycleTestServlet() {
        System.out.println("서블릿 컨테이너에 의해 서블릿 생성됨...");
        System.out.println(this instanceof Servlet);
        System.out.println(this instanceof HttpServlet);
    }
    
    // 서블릿은 초기화를 생성자에서 하는게 아니라 init 메소드로 함. 자동으로 호출됨
    // 처음 한 번만 로딩됨
    @Override
    public void init(ServletConfig config) throws ServletException {
    	counter = 0;
    	System.out.println(counter);
    	
    	// JDBC 드라이버 로딩
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

    // 굳이 할 필요 없음. 필요할 경우는 if else 코드 추가 필요.
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	System.out.println("서블릿 컨테이너에 의해 service() 메소드 호출됨");
//    	if(req.getMethod().equalsIgnoreCase("get")) {
//    		doGet(req, resp);
//    	}else {
//    		doPost(req, resp);
//    	}
//    	
//    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("브라우저 GET 방식 요청됨");
		counter++;
		
		// 브라우저에 데이터 출력
		// 응답메시지 헤더에 데이터 종류 설정
		
		StringBuilder tableSb = new StringBuilder(); 
		tableSb.append("<table border='1'>")
		.append("<tr>")
		.append("<th>부서번호</th><th>부서이름</th><th>상사번호</th><th>지역번호</th>")
		.append("</tr>");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT department_id, department_name, manager_id, location_id")
 		  .append(" FROM departments") 
		  .append(" ORDER BY department_id");
		
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int departmentId = rs.getInt("department_id");
				String departmentName= rs.getString("department_name");
				int managerId= rs.getInt("manager_id");
				int locationId = rs.getInt("location_id");
//				System.out.println(departmentId + "\t" + departmentName + "\t" + managerId + "\t" + locationId);
				tableSb.append("<tr><td>"+departmentId+"</td><td>"+departmentName+"</td><td>"+managerId+"</td><td>"+locationId+"</td></tr>");
			}
			tableSb.append("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		// 동적 콘텐츠 출력
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 프로그래밍</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>당신은 "+counter+"번째 방문자입니다.</h1>");
		out.println(tableSb.toString());
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("브라우저 POST 방식 요청됨");
	}
	
	@Override
	public void destroy() {
		counter = 0;
	}

}
