package com.focus.board.service;

import java.util.List;
import java.util.Map;

import com.focus.board.model.ReboardDto;


public interface ReboardService {

	List<ReboardDto> listArticle(Map<String, String> map);

	int writeArticle(ReboardDto reboardDto);

	ReboardDto viewArticle(int seq);

	int commentArticle(ReboardDto reboardDto);

	int modifyArticle(ReboardDto reboardDto);

	void deleteArticle(int seq);

}
