package com.focus.member.model;

public class MemberDto extends ProfileDto {
	
	int MSEQ;
	String M_ID;
	String M_PASS;
	String M_NAME;
	String M_JOB;
	String M_AGE;
	String M_EMAIL;
	String M_TEL;
	String M_INTRODUCE;
	String M_CAREER;
	String M_SKILL;
	String M_SNS;
	
	
	public String getM_SNS() {
		return M_SNS;
	}
	public void setM_SNS(String m_SNS) {
		M_SNS = m_SNS;
	}
	public String getM_PASS() {
		return M_PASS;
	}
	public void setM_PASS(String m_PASS) {
		M_PASS = m_PASS;
	}
	public int getMSEQ() {
		return MSEQ;
	}
	public void setMSEQ(int mSEQ) {
		MSEQ = mSEQ;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public String getM_NAME() {
		return M_NAME;
	}
	public void setM_NAME(String m_NAME) {
		M_NAME = m_NAME;
	}
	public String getM_JOB() {
		return M_JOB;
	}
	public void setM_JOB(String m_JOB) {
		M_JOB = m_JOB;
	}
	public String getM_AGE() {
		return M_AGE;
	}
	public void setM_AGE(String m_AGE) {
		M_AGE = m_AGE;
	}
	public String getM_EMAIL() {
		return M_EMAIL;
	}
	public void setM_EMAIL(String m_EMAIL) {
		M_EMAIL = m_EMAIL;
	}
	public String getM_TEL() {
		return M_TEL;
	}
	public void setM_TEL(String m_TEL) {
		M_TEL = m_TEL;
	}
	public String getM_INTRODUCE() {
		return M_INTRODUCE;
	}
	public void setM_INTRODUCE(String m_INTRODUCE) {
		M_INTRODUCE = m_INTRODUCE;
	}
	public String getM_CAREER() {
		return M_CAREER;
	}
	public void setM_CAREER(String m_CAREER) {
		M_CAREER = m_CAREER;
	}
	public String getM_SKILL() {
		return M_SKILL;
	}
	public void setM_SKILL(String m_SKILL) {
		M_SKILL = m_SKILL;
	}
	
	
}
