package com.focus.board.service;

import java.util.List;
import java.util.Map;

import com.focus.board.model.BoardDto;
import com.focus.board.model.ReboardDto;


public interface BoardService {
	
	List<BoardDto> listArticle(Map<String, String> map);
	
	int writeArticle(BoardDto boardDto);
	
	BoardDto viewArticle(int seq);
	
	int modifyArticle(BoardDto boardDto);

	void deleteArticle(int seq);

}
