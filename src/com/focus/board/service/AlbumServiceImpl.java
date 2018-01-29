package com.focus.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus.board.model.AlbumDto;
import com.focus.common.dao.CommonDao;
import com.focus.board.dao.AlbumDao;
import com.focus.util.BoardConstance;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<AlbumDto> listArticle(Map<String, String> map) {
		AlbumDao albumDao = sqlSession.getMapper(AlbumDao.class);
		int pg = Integer.parseInt(map.get("pg"));
		int end = BoardConstance.ALBUM_LIST_SIZE * pg;
		int start = end - BoardConstance.ALBUM_LIST_SIZE;
		map.put("start", start + "");
		map.put("end", end + "");
		return albumDao.listArticle(map);
	}

	@Override
	@Transactional
	public int writeArticle(AlbumDto albumDto) {
		AlbumDao albumDao = sqlSession.getMapper(AlbumDao.class);
		albumDao.bwriteArticle(albumDto);
		albumDao.awriteArticle(albumDto);
		return 1;
	}

	@Override
	public AlbumDto viewArticle(int seq) {
		// TODO Auto-generated method stub
				CommonDao commonDao = sqlSession.getMapper(CommonDao.class);
				commonDao.updateHit(seq);
				AlbumDao albumDao = sqlSession.getMapper(AlbumDao.class);
				return albumDao.viewArticle(seq);
	}

	@Override
	public void deleteArticle(int seq) {
		AlbumDao albumDao = sqlSession.getMapper(AlbumDao.class);
		albumDao.deleteBoard(seq);		
	}

}
