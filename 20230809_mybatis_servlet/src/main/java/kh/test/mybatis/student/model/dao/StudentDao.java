package kh.test.mybatis.student.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.mybatis.student.model.vo.StudentVo;

public class StudentDao {
	
	//sql 명령어 별로 메소드 관리함 //여기 메소드랑 mapper id랑 같음 =>그걸 꺼내겠다. 
	public List<StudentVo> selectList(SqlSession session) {
		List<StudentVo> result = session.selectList("student1.selectList0"); // string형태로 적음 "namespace.id" //(..)<-mapper.xml	
		return result;
	}
	public StudentVo selectList(SqlSession session, String studentNo4) {
		StudentVo result = session.selectOne("student1.selectOne0", studentNo4); // string형태로 적음 "namespace.id" //(..)<-mapper.xml
		return result;																// "namespace.id".parameter(매개인자)
	}
	public int insert(SqlSession session, StudentVo vo) {
		int result = session.insert("student1.insert0", vo);
		return result;
	}

}
