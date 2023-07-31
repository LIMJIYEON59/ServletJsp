package kh.test.jdbckh.board.model.dao;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.member.model.dto.Member;


public class MemberDao {
		// 모든 행 읽기
		public List<Member> selectList(Connection conn) {
			System.out.println("[Member Dao selectList]");
			List<Member> result = new ArrayList<Member>();

			String query = " select BNO, BTITLE, to_char(BWRITE_DATE, 'yyyy-mm-dd hh24:mi:ss') BWRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD ";
			

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					Member dto = new Member(
//							rs.getInt("BNO"),
//							rs.getString("BTITLE"),
//							rs.getString("BWRITE_DATE"),
//							rs.getString("MID"),
//							rs.getInt("BREF"),
//							rs.getInt("BRE_LEVEL"),
//							rs.getInt("BRE_STEP")					
							);
					result.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("[Member Dao selectList] return:" + result);
			return result;
		}

		// 한 행 읽기 - PK로where조건
		public Member selectOne(Connection conn, int bno) {
			System.out.println("[Member Dao selectOne] bno:" + bno);
			Member result = null;
			// TODO
			System.out.println("[Member Dao selectOne] return:" + result);
			return result;
		}

		// 한 행 삽입 - Member 자료형을 받아와야 함.
		public int insert(Connection conn, Member dto) {
			System.out.println("[Member Dao insert] dto:" + dto);
			int result = 0;
			String query = "";
			
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				//TODO
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Member Dao insert] return:" + result);
			return result;
		}
		public int insertReply(Connection conn, Member dto) {
			System.out.println("[Member Dao insertReply] dto:" + dto);
			int result = 0;
			String query = "insert into BOARD values (SEQ_BOARD_BNO.nextval, ?, ?, default, ?    , (select bref from board where bno=?)    , (select bre_level+1 from board where bno=?)    , (select bre_step+1 from board where bno=?)    )";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				//TODO
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Member Dao insertReply] return:" + result);
			return result;
		}
		// 한 행 수정 - Member 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
		public int update(Connection conn, Member dto) {
			System.out.println("[Member Dao update] dto:" + dto);
			int result = -1;  // update 경우 0도 정상 결과값일 수 있으므로 -1을 초기값
			String query = "update board set BRE_STEP = BRE_STEP + 1 where BRE_STEP > (select bre_step from board where bno=?)  and BREF = (select bref from board where bno=?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
		
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Member Dao update] return:" + result);
			return result;
		}

		// 한 행 삭제 - 주로 PK로 where조건
		public int delete(Connection conn, int bno) {
			System.out.println("[Member Dao delete] bno:" + bno);
			int result = 0;
			// TODO
			System.out.println("[Member Dao delete] return:" + result);
			return result;
		}


}
