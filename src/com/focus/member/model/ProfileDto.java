package com.focus.member.model;

public class ProfileDto {
	
	int PSEQ;
	String ORIGIN_PHOTO;
	String SAVE_PHOTO;
	String SAVEFOLDER;
	String TYPE;
	String MSEQ;
	
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
	public void setSAVEFOLDER(String sAVEFOLDER) {
		SAVEFOLDER = sAVEFOLDER;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getMSEQ() {
		return MSEQ;
	}
	public void setMSEQ(String mSEQ) {
		MSEQ = mSEQ;
	}

}
