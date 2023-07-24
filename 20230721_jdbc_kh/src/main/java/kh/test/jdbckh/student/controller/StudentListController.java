package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentListController
 */
//"student list"이걸 웹페이지 거서 다시 실행 시켜야함(f5)
@WebServlet({ "/student/list" })
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentListController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/student/list doGet() 진입");
		// TODO DB 연동하겠다(파일 만들어야 함 class -> vo랑 dao만듬 dao를 통해 student정보(데이터베이스 정보)읽고
		// vo에다가 채워주겠다. 그리고 그 값을 화면에도 뿌려준다.)
		// 즉 vo = 자료형, dao = 기능위주

		// 1. 전달받은 parameter 읽어내기
		// 2. 전달받은 데이터를 활용해 DB학생 상세 정보 가져오기
		
		// dao에 있는 애를 불러 오겠다. 객체 생성 해야함 그리고 불러오는 거 작성
		// dao의 result에 값을 넣겠다. 그리고 그 값을 아래 링크(jsp)로 넣겠다.!!
		StudentDao dao = new StudentDao();
		// 3. DB로부터 전달받은 데이터를 JSP에 전달함(dao 부분이랑 StudentDao랑 연결됨)
		List<StudentVo> result = dao.selectListStudent();
		request.setAttribute("studentList", result); // request에 "" 속성명과 result 값이 생김
		// 4. Jsp 파일 forward로 만들기
		request.getRequestDispatcher("/WEB-INF/veiw/student/list.jsp").forward(request, response);
		// jsp한테 request도 주고 response도 준다.(바로 위 코드)

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
