package com.focus.admin.board.dao;

import java.util.List;
import java.util.Map;

import com.focus.admin.board.model.BoardListDto;
import com.focus.admin.board.model.HotListDto;
import com.focus.admin.board.model.RecentBookListDto;

public interface BoardAdminDao {

	List<BoardListDto> boardMenu();

	List<HotListDto> hotlist(Map<String,String> map);

	List<RecentBookListDto> rblist(Map<String, String> map);

}
