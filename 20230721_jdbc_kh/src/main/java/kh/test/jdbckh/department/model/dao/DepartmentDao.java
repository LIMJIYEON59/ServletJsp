package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.department.model.vo.DepartmentVo;

public class DepartmentDao {
	
	public DepartmentVo selectOnedepartment(String departmentNo) {
		System.out.println("DAO selectOneStudent() arg:" + departmentNo);
		
		DepartmentVo result = null;
		String query = "select * from tb_department where department_no = " + "'"+departmentNo+"'";
		
		//위
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:8090:xe", "kh", "kh");
			
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
//			
//			private String departmentNo;
//			private String departmentName;
//			private String Category;
//			private String OpenYn;
//			private String Capacity;
//			
			
			if(rset.next()) {
				//result new 생성해주기
				result = new DepartmentVo();
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setDepartmentName(rset.getString("Department_Name"));
				result.setCategory(rset.getString("Category"));
				result.setOpenYn(rset.getString("Open_Yn"));
				result.setCapacity(rset.getInt("Capacity"));
				
			}
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		System.out.println(result);
		return result;
		
		
		
		
	}
	
	public List<DepartmentVo> selectDepatmentList() {
		List<DepartmentVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_department";
		
		
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn = DriverManager.getConnection("jdbc:oracle:thinL@127.0.0.1:1521:XE","kh", "kh");
						pstmt = conn.prepareStatement(query);
						rs=pstmt.executeQuery();
						
						result = new ArrayList<DepartmentVo>();
						while (rs.next() == true) {
							DepartmentVo vo = new DepartmentVo();
							vo.setDepartmentName(rs.getString("department_name"));
							vo.setCategory(rs.getString("category"));
							vo.setOpenYn(rs.getString("open_yn"));
							vo.setCapacity(rs.getInt("capacity"));
							
							result.add(vo);
						}
						
						
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							rs.close();
							pstmt.close();
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				
				
				
				
				
				return result;
			}

		}