package com.foucs.member.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.focus.member.dao.MemberDao;
import com.focus.member.model.MemberDto;

public class MemberServiceImpl implements MemberService {
	
private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

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
		return memberDao.login(map);
	}

}
