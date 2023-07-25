package kh.test.jdbckh.common.jdbc;
//Dao
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//1번과 2번 그리고 conn리턴 해주는 거 
public class JdbcTemplate {
	private static Connection conn = null;
	
	
	// Singleton Connection 객체가 많이 생성됨을 방지
	public Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
