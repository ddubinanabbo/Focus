package com.foucs.member.service;

import com.focus.member.model.MemberDto;

public interface MemberService {
	
	int idcheck(String id);
	int registerMember(MemberDto memberDto);
	MemberDto login(String M_ID, String M_PASS);

}
