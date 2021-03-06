package com.focus.board.dao;

import java.util.List;
import java.util.Map;

import com.focus.board.model.ReboardDto;

public interface ReboardDao {

	List<ReboardDto> listArticle(Map<String, String> map);

	void rwriteArticle(ReboardDto reboardDto);

	void bwriteArticle(ReboardDto reboardDto);

	ReboardDto viewArticle(int seq);

	void updateStep(ReboardDto reboardDto);

	void bcommentArticle(ReboardDto reboardDto);

	void rcommentArticle(ReboardDto reboardDto);

	void updateReply(int pseq);

	int modifyArticle(ReboardDto reboardDto);

	void deleteBoard(int seq);

}
