package kh.test.jdbckh.student.model.service;

import java.util.List;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentService {
	//DB 일처리 단위별로 넣어줌 (DAO를 위해서)
	
	public StudentVo selectOneStudent(String studentNo) {
		return new StudentDao().selectOneStudent(studentNo); 
	}
	public List<StudentVo> selectListStudent() {
		return new StudentDao().selectListStudent(); 
	}
	public List<StudentVo> selectListStudent(String searchWord) {	//검색
		return new StudentDao().selectListStudent(searchWord); 
	}
	public List<StudentVo> selectListStudent(int currentPage, int pageSize) {	// 페이징처리
		return new StudentDao().selectListStudent(currentPage,pageSize); 
	}
	public int getTotalCount() {
		return new StudentDao().getTotalCount();
	}
}
