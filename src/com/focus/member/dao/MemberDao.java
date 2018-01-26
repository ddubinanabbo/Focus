package com.focus.member.dao;

import java.util.Map;

import com.focus.member.model.MemberDto;
import com.focus.member.model.ProfileDto;

public interface MemberDao {
	
	int idcheck(String id);
	int registerMember(MemberDto memberDto);
	MemberDto login(Map<String, String> map);
	MemberDto findAccount(Map<String, String> map);
	void updatepwd(Map<String, String> map);
	int uploadProfile(ProfileDto profileDto);
	ProfileDto viewProfile(int MSEQ);
	int modifyprofile(MemberDto memberDto);

}
