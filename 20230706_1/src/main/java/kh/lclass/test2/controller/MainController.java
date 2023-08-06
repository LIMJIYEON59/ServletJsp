package kh.lclass.test2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/index")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Dispatcher -forward 함(jsp를 열어달라 그 파일이 대신 reponse 할 수 있도록 해주는 것) =>그리고 나서 여기에 걸어줄 jsp를 만든다.(index)
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

}
