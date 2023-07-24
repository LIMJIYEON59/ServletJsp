package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentDao {
// PPT 내용구현
	
	// DB에서 tb_student 테이블의 전달받은 학번을 통해 학생1명의 상세정보를 읽어옴
	public StudentVo selectOneStudent(String studentNo) {
		// 위에 (String studentNo)파라메타를 받아온다
		System.out.println("DAO selectOneStudent() arg:"+ studentNo);
		
		
		StudentVo result = null;
		String query = "select * from tb_student where student_no = " + "'"+studentNo+"'";
	
		// DB연결하기 class 이름들 좍 다 작성하기 (try-cath 문을 사용하기 때문에)
		// 위에 먼저 작성하고 밑에 Class작성하면 try-catch문 가능해짐
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//HTTP:8090 //Process:1521(오라클 내부접속할 때)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
	
			// 연결 시키려고 if랑 else문 돌린거(1521)
//			if(conn==null) {
//				System.out.println("연결실패");
//			}else {
//				System.out.println("연결 성공");
//			}
			
			
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				//result new 생성해줘야한다.
				result = new StudentVo();
				//while 동작시킬필요없음. qyery 결과가 단일행일 것이므로
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNO(rset.getString("Department_No"));
				result.setEntranceDate(rset.getDate("Entrance_Date"));		
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
				result.setStudentName(rset.getString("Student_Name"));
				result.setStudentNO(rset.getString("Student_No"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		
		// finally블럭은 생성순서 반대로한다.
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		//확인됐으면 이거 없애준다. (확인 다 됐으니-전에꺼는 엄청 길어서 괜찮았는데 지금은 한 줄이라서 그냥 냅둬도 상관없다.)
		System.out.println(result);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// DB에서 tb_student 테이블의 있는 모든 내용을 읽어서 꺼냄. 
	// selectListStudent() 이 메소드는  List<StudentVo> 이걸로 리턴 할거여(return result;)
	public List<StudentVo> selectListStudent() {
		List<StudentVo> result = null;
		Connection conn = null;
		Statement stmt = null; //얘가 부모 나머지들이 자식들
		PreparedStatement pstmt = null;

		try {
			
			// 1. driver 있다면 로딩함. // 없다면 ClassNotFoundException
		    // Class.forName("oracle.jdbc.driver.OracleDriver"); Class.forName를 기억한다. try-catch로 묶음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 객체 생성 // dbms와 연결
			//getConnection 이 메소드르 통해 Connection 이 객체가 만들어짐
			// conn을 통해 이것저것 전달 해주는데 엄청나게 양이 왔다갔다 하니 close를 꼭 해줘야 함 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			if(conn != null) {
				System.out.println("DB연결 성공!!!!!!!");
			}else {
				System.out.println("--------DB 연결 실패--------");
			}
			
			//3. Statement/prepareStatment 객체 생성 - conn 객체로부터 - query 문을 실어보냄
			// 이것도 똑같이 저 메소드들이 앞에 객체들을 만들어줌
//			 stmt = conn.createStatement();
			//"sql 쿼리문"을 적는다!
			 String query = "select * from tb_student";
			 pstmt = conn.prepareStatement(query);
			
			 // 4. query 문을 실행해달라고 함 - 그 결과값을 return 받음
			 // select query 문이면 ResultSet 모양
			 // insert/update/delete 문이면 int 모양
			 ResultSet rs = pstmt.executeQuery();
			 
			 // 5. ResultSet 에서 row(record) = 한줄씩! 읽어오기 위해 cursor(포인트)를 이동함.
			 result = new ArrayList<StudentVo>();
			 while(rs.next() == true) {
				 // 한줄 row/record를 읽을 준비 완료
				 // rs야 컬럼명에 대한걸 읽어줘
				 // 확인용도. System.out.println(rs.getString("STUDENT_NAME"));
				 StudentVo vo = new StudentVo();
				 vo.setStudentNO(rs.getString("student_no"));
				 vo.setDepartmentNO(rs.getString("department_no"));
				 vo.setStudentName(rs.getString("Student_Name"));
				 vo.setAbsenceYn(rs.getString("Absence_Yn"));
				 vo.setCoachProfessorNo(rs.getString("Coach_Professor_No"));
				 vo.setStudentAddress(rs.getString("Student_Address"));
				 vo.setEntranceDate(rs.getDate("Entrance_Date"));
				 vo.setStudentSsn(rs.getString("Student_Ssn"));
				
				 result.add(vo);
			 }
			 
		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) {
					pstmt.close();					
				}
				if(stmt!=null) {
					stmt.close();	
				}
				if(conn!=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} 
		
		// 확인용 System.out.println(result);
		return result;
	}

}
