package kh.test.jdbckh.common.jdbc;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		//
		try {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return session;
	}

}
