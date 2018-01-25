package com.focus.admin.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus.admin.board.dao.BoardAdminDao;
import com.focus.admin.board.model.BoardListDto;

@Service
public class BoardAdminSerivceImpl implements BoardAdminService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardListDto> boardMenu() {
		System.out.println("service");
		BoardAdminDao boardAdminDao = sqlSession.getMapper(BoardAdminDao.class);
		return boardAdminDao.boardMenu();
		}

}
