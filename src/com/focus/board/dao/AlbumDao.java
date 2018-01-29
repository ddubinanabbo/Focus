package com.focus.board.dao;

import java.util.List;
import java.util.Map;

import com.focus.board.model.AlbumDto;

public interface AlbumDao {

	List<AlbumDto> listArticle(Map<String, String> map);


	void bwriteArticle(AlbumDto albumDto);

	void awriteArticle(AlbumDto albumDto);


	AlbumDto viewArticle(int seq);


	void deleteBoard(int seq);

}
