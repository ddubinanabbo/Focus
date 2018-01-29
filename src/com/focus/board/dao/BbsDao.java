package com.focus.board.dao;

import java.util.List;
import java.util.Map;

import com.focus.board.model.BbsDto;

public interface BbsDao {

	List<BbsDto> listArticle(Map<String, String> map);

	void bwriteArticle(BbsDto bbsDto);

	void bswriteArticle(BbsDto bbsDto);

	BbsDto viewArticle(int seq);

	void bmodifyArticle(BbsDto bbsDto);

	void bsmodifyArticle(BbsDto bbsDto);

	void deleteBoard(int seq);

}
