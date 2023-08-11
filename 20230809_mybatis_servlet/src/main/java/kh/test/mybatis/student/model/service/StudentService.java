package kh.test.mybatis.student.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.mybatis.common.MyBatisTemplate;
import kh.test.mybatis.student.model.dao.StudentDao;
import kh.test.mybatis.student.model.vo.StudentVo;

public class StudentService {
	private StudentDao dao;

	public StudentService() {
			dao = new StudentDao(); //이런 생성 방식도 있다.
	}
	
	// service특징: connection 관리함. transaction 관리 
	public List<StudentVo> selectList() {
		List<StudentVo> result = null;	//지역변수
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.selectList(session);
		session.close();
		return result;
	}
	public StudentVo selectOne(SqlSession session, String studentNo4){
		StudentVo result = session.selectOne("student1.selectOne0", studentNo4);// "namespace.id", parameter		
		return result;
	}
	public int insert(SqlSession session, StudentVo vo) {
		int result = session.insert("student1.insert0", vo);
		return result;
	}

}
