package com.focus.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus.board.dao.ReboardDao;
import com.focus.board.model.ReboardDto;
import com.focus.common.dao.CommonDao;
import com.focus.util.BoardConstance;

@Service
public class ReboardServiceImpl implements ReboardService {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ReboardDto> listArticle(Map<String, String> map) {
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		int pg = Integer.parseInt(map.get("pg"));
		int end = BoardConstance.BOARD_LIST_SIZE * pg;
		int start = end - BoardConstance.BOARD_LIST_SIZE;
		map.put("start", start + "");
		map.put("end", end + "");
		return reboardDao.listArticle(map);
	}

	@Override
	@Transactional
	public int writeArticle(ReboardDto reboardDto) {
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		reboardDao.bwriteArticle(reboardDto);
		reboardDao.rwriteArticle(reboardDto);
		return 1;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		// TODO Auto-generated method stub
		CommonDao commonDao = sqlSession.getMapper(CommonDao.class);
		commonDao.updateHit(seq);
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		return reboardDao.viewArticle(seq);
	}

}
