package com.focus.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus.board.dao.AlbumDao;
import com.focus.board.dao.BbsDao;
import com.focus.board.model.AlbumDto;
import com.focus.board.model.BbsDto;
import com.focus.common.dao.CommonDao;
import com.focus.common.service.CommonService;
import com.focus.util.BoardConstance;

@Service
public class BbsSerivceImpl implements BbsService {
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BbsDto> listArticle(Map<String, String> map) {
		BbsDao bbsDao = sqlSession.getMapper(BbsDao.class);
		int pg = Integer.parseInt(map.get("pg"));
		int end = BoardConstance.BOARD_LIST_SIZE * pg;
		int start = end - BoardConstance.BOARD_LIST_SIZE;
		map.put("start", start + "");
		map.put("end", end + "");
		return bbsDao.listArticle(map);
	}
	
	@Override
	@Transactional
	public int writeArticle(BbsDto bbsDto) {
		BbsDao bbsDao = sqlSession.getMapper(BbsDao.class);
		bbsDao.bwriteArticle(bbsDto);
		bbsDao.bswriteArticle(bbsDto);
		return 1;
	}
	
	@Override
	public BbsDto viewArticle(int seq) {
		// TODO Auto-generated method stub
				CommonDao commonDao = sqlSession.getMapper(CommonDao.class);
				commonDao.updateHit(seq);
				BbsDao bbsDao = sqlSession.getMapper(BbsDao.class);
				return bbsDao.viewArticle(seq);
	}

	@Override
	@Transactional
	public int modifyArticle(BbsDto bbsDto) {
		BbsDao bbsDao = sqlSession.getMapper(BbsDao.class);
		bbsDao.bmodifyArticle(bbsDto);
		bbsDao.bsmodifyArticle(bbsDto);
		return 1;
	}

	@Override
	public void deleteArticle(int seq) {
		BbsDao bbsDao = sqlSession.getMapper(BbsDao.class);
		bbsDao.deleteBoard(seq);		
	}
}
