package com.foucs.member.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.focus.member.dao.MemberDao;
import com.focus.member.model.MemberDto;

public class MemberServiceImpl implements MemberService {
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int idcheck(String id) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.idcheck(id);
	}
	
	@Override
	public int registerMember(MemberDto memberDto) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);

		return memberDao.registerMember(memberDto);
	}
	
	@Override
	public MemberDto login(String M_ID, String M_PASS) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);

		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", M_ID);
		map.put("userpwd", M_PASS);
		System.out.println("membeDao : " + memberDao);
		return memberDao.login(map);
	}

	@Override
	public MemberDto findAccount(String M_ID, String M_EMAIL) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", M_ID);
		map.put("usermail", M_EMAIL);
		
		return memberDao.findAccount(map);
	}

	@Override
	public void updatepwd(String M_ID, String M_PASS) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);

		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", M_ID);
		map.put("userpwd", M_PASS);
		memberDao.updatepwd(map);
		
	}

}
