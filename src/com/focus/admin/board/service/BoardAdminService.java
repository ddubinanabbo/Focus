package com.focus.admin.board.service;

import java.util.List;
import java.util.Map;

import com.focus.admin.board.model.BoardListDto;
import com.focus.admin.board.model.HotListDto;
import com.focus.admin.board.model.RecentBookListDto;

public interface BoardAdminService {

	List<BoardListDto> boardMenu();

	List<HotListDto> hotlist();

	List<RecentBookListDto> rblist();

}
