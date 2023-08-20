package kh.test.mybatis.common;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getSqlSession() {
		//String resource = "mybatis/mybatis-config.xml";
		SqlSession session = null; // 얘는 Connection 역할을 한다. mybatis의 객체
		try {
			// InputStream으로 Mybatis의 설정 정보를 읽어 온다.
			// InputStream is = Resources.getResourceAsStream(resource);
			// 읽어 온 Mybatis의 설정 정보를 바탕으로 SqlSessionFactoryBuilder를 생성한다. 
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis-config.xml"));	//InputStream-build
			session = factory.openSession();	//결과적으로는 이 session을 만드는게 목표이다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}
