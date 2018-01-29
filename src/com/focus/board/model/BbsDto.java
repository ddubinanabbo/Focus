package com.focus.board.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BbsDto extends BoardDto{
	
	private int BSEQ;
	private String ORIGIN_FILE;
	private String SAVE_FILE;
	private int FILESIZE;
	private String SAVEFOLDER;
	private List<MultipartFile> upfile;
	
	public int getBSEQ() {
		return BSEQ;
	}
	public void setBSEQ(int bSEQ) {
		BSEQ = bSEQ;
	}
	public String getORIGIN_FILE() {
		return ORIGIN_FILE;
	}
	public void setORIGIN_FILE(String oRIGIN_FILE) {
		ORIGIN_FILE = oRIGIN_FILE;
	}
	public String getSAVE_FILE() {
		return SAVE_FILE;
	}
	public void setSAVE_FILE(String sAVE_FILE) {
		SAVE_FILE = sAVE_FILE;
	}
	
	public int getFILESIZE() {
		return FILESIZE;
	}
	public void setFILESIZE(int fILESIZE) {
		FILESIZE = fILESIZE;
	}
	public String getSAVEFOLDER() {
		return SAVEFOLDER;
	}
	public void setSAVEFOLDER(String sAVEFOLDER) {
		SAVEFOLDER = sAVEFOLDER;
	}
	public List<MultipartFile> getUpfile() {
		return upfile;
	}
	public void setUpfile(List<MultipartFile> upfile) {
		this.upfile = upfile;
	}

}
