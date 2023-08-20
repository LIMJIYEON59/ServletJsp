package kh.test.jdbckh.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.test.jdbckh.board.model.dto.AttachFileDto;
import kh.test.jdbckh.board.model.dto.BoardDto;


public class BoardDao {
	public List<AttachFileDto> selectAttachFileList(SqlSession session, int bno) {
		System.out.println("[Board Dao selectList]");
		List<AttachFileDto> result = session.selectList("boardMapper1.selectAttachFile1", bno); 
		System.out.println("[Board Dao selectList] return:" + result);
		return result;
	}
	public BoardDto selectOne(SqlSession session, int bno) {
		System.out.println("[Board Dao selectList]");
		BoardDto result = session.selectOne("boardMapper1.selectOne1", bno);
		System.out.println("[Board Dao selectList] return:" + result);
		return result;
	}
	public int selectOne(SqlSession session, BoardDto dto, int nextVal) {
		System.out.println("[Board Dao insert]");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dto", dto);
		map.put("nextVal", nextVal);
		int result = session.insert("boardMapper1.insert1", map);
		System.out.println("[Board Dao insert] return:" + result);
		return result;
	}

}