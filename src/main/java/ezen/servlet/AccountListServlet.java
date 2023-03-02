package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.servlet.repository.Account;
import ezen.servlet.repository.AccountRepository;
import ezen.servlet.repository.JdbcAccountRepository;
import ezen.servlet.repository.MinusAccount;

/**
 * 서버에서 관리하고 있는 계좌 목록 서비스 서블릿
 */
@WebServlet("/account/list")
public class AccountListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AccountRepository repository = new JdbcAccountRepository();
			List<Account> list = repository.getAccounts();
			PrintWriter out= response.getWriter();
			
			response.setContentType("text/html; charset=utf8");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>서블릿 프로그래밍</title>");
			out.println("<link rel='stylesheet' href='"+request.getContextPath()+"/css/table.css'>");
			out.println("</head>");
			
			out.println("<body>");
			out.println("<table>");
			
			// NullPointerException ...
			for (Account account : list) {
				out.println("<tr>");
				out.println("<td>"+account.getAccountNumber()+"</td>");
				out.println("<td>"+account.getAccountOwner()+"</td>");
				out.println("<td>"+account.getPassword()+"</td>");
				out.println("<td>"+account.getRestMoney()+"</td>");
				long borrowMoney = 0;
				Date rentDate = new Date(System.currentTimeMillis());
				rentDate = null;
				if(account instanceof MinusAccount) {
					borrowMoney= ((MinusAccount) account).getRentMoney();
					rentDate = ((MinusAccount) account).getRentDate();
				}
				out.println("<td>"+borrowMoney+"</td>");
				out.println("<td>"+rentDate+"</td>");
				
				out.println("</tr>");	
			}
			
			
			out.println("</table>");
			
			
			out.println("</body>");
			out.println("</html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
