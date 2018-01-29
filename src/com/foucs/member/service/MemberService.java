package com.foucs.member.service;

import com.focus.member.model.MemberDto;
import com.focus.member.model.ProfileDto;

public interface MemberService {
	
	int idcheck(String id);
	int registerMember(MemberDto memberDto);
	MemberDto login(String M_ID, String M_PASS);
	MemberDto findAccount(String M_ID, String M_EMAIL);
	void updatepwd(String M_ID, String M_PASS);
	int uploadProfile(ProfileDto profileDto);
	ProfileDto viewProfile(int MSEQ);
	int modifyprofile(MemberDto memberDto);
	int checksocialid(String slid, String slname);
	int registersnsMember(MemberDto memberDto);
	MemberDto snslogin(String slid,String slname);
}
