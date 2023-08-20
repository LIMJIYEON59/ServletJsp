package kh.test.jdbckh.common.jdbc;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;	//Connection 역할을 하는 mybatis의 개체
		try {
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis-config.xml"));	//() <- resource 바로 아래 만들어져서 그냥 쓰면됨 !! 근데 "/" 이거 안 붙이고! 
			session = factory.openSession(autoCommit);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}
