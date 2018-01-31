package com.focus.admin.board.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus.admin.board.dao.BoardAdminDao;
import com.focus.admin.board.model.BoardListDto;
import com.focus.admin.board.model.HotListDto;
import com.focus.admin.board.model.RecentBookListDto;

@Service
public class BoardAdminSerivceImpl implements BoardAdminService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardListDto> boardMenu() {
		BoardAdminDao boardAdminDao = sqlSession.getMapper(BoardAdminDao.class);
		return boardAdminDao.boardMenu();
		}

	@Override
	public List<HotListDto> hotlist() {
		BoardAdminDao boardAdminDao = sqlSession.getMapper(BoardAdminDao.class);
		Map<String,String> map = new HashMap<String,String>();
		map.put("btype", "2");
		map.put("end", "5");
		return boardAdminDao.hotlist(map);
	}

	@Override
	public List<RecentBookListDto> rblist() {
		BoardAdminDao boardAdminDao = sqlSession.getMapper(BoardAdminDao.class);
		Map<String,String> map = new HashMap<String,String>();
		DateFormat df = new SimpleDateFormat("yyMMdd");
		String now = df.format(new Date());
		map.put("now", now);
		map.put("end", "4");
		return boardAdminDao.rblist(map);
	}

}
