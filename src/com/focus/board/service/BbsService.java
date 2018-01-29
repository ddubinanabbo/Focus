package com.focus.board.service;

import java.util.List;
import java.util.Map;

import com.focus.board.model.BbsDto;


public interface BbsService {

	List<BbsDto> listArticle(Map<String, String> map);

	int writeArticle(BbsDto bbsDto);
	
	BbsDto viewArticle(int seq);

	int modifyArticle(BbsDto bbsDto);

	void deleteArticle(int seq);

}
