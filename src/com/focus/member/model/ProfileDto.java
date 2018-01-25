package com.focus.member.model;


import org.springframework.web.multipart.MultipartFile;

public class ProfileDto {
	
	private int PSEQ;
	private String ORIGIN_PHOTO;
	private String SAVE_PHOTO;
	private String SAVEFOLDER;
	private String TYPE;
	private int MSEQ;
	private MultipartFile upfile;
	
	public int getPSEQ() {
		return PSEQ;
	}
	public void setPSEQ(int pSEQ) {
		PSEQ = pSEQ;
	}
	public String getORIGIN_PHOTO() {
		return ORIGIN_PHOTO;
	}
	public void setORIGIN_PHOTO(String oRIGIN_PHOTO) {
		ORIGIN_PHOTO = oRIGIN_PHOTO;
	}
	public String getSAVE_PHOTO() {
		return SAVE_PHOTO;
	}
	public void setSAVE_PHOTO(String sAVE_PHOTO) {
		SAVE_PHOTO = sAVE_PHOTO;
	}
	public String getSAVEFOLDER() {
		return SAVEFOLDER;
	}
	public int getMSEQ() {
		return MSEQ;
	}
	public void setMSEQ(int mSEQ) {
		MSEQ = mSEQ;
	}
	public void setSAVEFOLDER(String sAVEFOLDER) {
		SAVEFOLDER = sAVEFOLDER;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	
}
