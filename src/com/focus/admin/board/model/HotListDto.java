package com.focus.admin.board.model;

import com.focus.board.model.BoardDto;

public class HotListDto extends BoardDto{
	
	private String cname;
	private String btype_name;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getBtype_name() {
		return btype_name;
	}
	public void setBtype_name(String btype_name) {
		this.btype_name = btype_name;
	}
	

}
