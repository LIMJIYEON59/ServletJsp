package kh.test.jdbckh.board.model.service;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.getConnectionkh1;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.setAutoCommit;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.commit;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.test.jdbckh.board.model.dao.BoardDao;
import kh.test.jdbckh.board.model.dao.MemberDao;
import kh.test.jdbckh.board.model.dto.AttachFileDto;
import kh.test.jdbckh.board.model.dto.BoardDto;
import kh.test.jdbckh.common.jdbc.MyBatisTemplate;

public class BoardService {
	private BoardDao dao = new BoardDao();
	private MemberDao mdao = new MemberDao();
	// 모든 행 읽기
	public List<BoardDto> selectList(){
		List<BoardDto> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true); //호출하고 생성(연결) //true 꼭 넣어야 함!
		//result = dao.selectList(session);
		session.close();	//그 객체가 여기서 닫힘
		return result;
	}
	// 한 행 읽기 - PK로where조건
	public BoardDto selectOne(int bno){
		BoardDto result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectOne(session, bno);
		if(result != null) {
			// 첨부파일들 읽어서 result에 넣기
			List<AttachFileDto> fileList = dao.selectAttachFileList(session, bno);
			result.selectAttachFileList(fileList);
		}
		session.close();
		return result;
	}
	// 한 행 삽입 - BoardDto 자료형을 받아와야 함.
	public int insert(BoardDto dto, List<AttachFileDto> fileList){
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession(false);
		//setAutoCommit(session, false);
		int nextval = dao.getSeqBoardBnoNexVal(session);
		if(dto.getBno() == 0) { // 원본글작성
			result = dao.insert(session, dto, nextval);
			if(fileList != null && fileList.size()>0) {
				result = dao.insertAttachFileList(session, fileList, nextval);
			}
		}else {   // 답글작성
			result = dao.update(session, dto);
			if(result > -1) {
				result = dao.insertReply(session, dto, nextval);
			}
			if(fileList != null && fileList.size()>0) {
				result = dao.insertAttachFileList(session, fileList, nextval);
			}
		}
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	// 한 행 수정 - BoardDto 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(BoardDto dto){
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession(true);	//<-괄호안에 true꼭 넣어줘야 함 아니라면 if~else commit(); 꼭해줘야함 (둘 중에 하나)
		//result = dao.update(conn, dto);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.commit();
		return result;
	}
	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(int bno){
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		//result = dao.delete(conn, bno);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.commit();
		return result;
	}
	
	//// 추가 
	// 페이징 처리 + 검색
	public int getTotalCount(String searchWord) {
		int result = 0;
		Connection conn = getConnectionkh1();
		//result = dao.getTotalCount(conn, searchWord);
		close(conn);
		return result;
	}
	public List<BoardDto> selectList(int currentPage, int pageSize, String searchWord){
		List<BoardDto> result = null;
		Connection conn = getConnectionkh1();
		int totalCount = getTotalCount(searchWord);
		//result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
		close(conn);
		return result;
	}
}