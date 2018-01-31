package com.focus.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.focus.board.dao.BoardDao;
import com.focus.board.dao.ReboardDao;
import com.focus.board.model.BoardDto;
import com.focus.common.dao.CommonDao;
import com.focus.util.BoardConstance;

public class BoardServiceImpl implements BoardService {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int pg = Integer.parseInt(map.get("pg"));
		int end = BoardConstance.BOARD_LIST_SIZE * pg;
		int start = end - BoardConstance.BOARD_LIST_SIZE;
		map.put("start", start + "");
		map.put("end", end + "");
		return boardDao.listArticle(map);
	}

	@Override
	public int writeArticle(BoardDto boardDto) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.writeArticle(boardDto);
		return 1;
	}

	@Override
	public BoardDto viewArticle(int seq) {
		CommonDao commonDao = sqlSession.getMapper(CommonDao.class);
		commonDao.updateHit(seq);
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		return boardDao.viewArticle(seq);
	}

	@Override
	public int modifyArticle(BoardDto boardDto) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);		
		return boardDao.modifyArticle(boardDto);
	}

	@Override
	public void deleteArticle(int seq) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.deleteBoard(seq);
		
	}

}
