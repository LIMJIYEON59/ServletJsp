package kh.test.jdbckh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("SsLoginId"); //이렇게 하면 로그아웃됨
		response.sendRedirect(request.getContextPath()+"/board/list");	
		//doget은 98% D,,, For...(r)..로 함 이러면 로그아웃 됐다고 페이지가 뜸 //근데 로그아웃 누르고 메인이 나오도록 하려면 send를 쓴다. 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
