package com.focus.board.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class AlbumDto extends BoardDto {
	
	private int ASEQ;
	private String ORIGIN_PICTURE;
	private String SAVE_PICTURE;
	private String SAVEFOLDER;
	private String TYPE;
	private List<MultipartFile> upfile;
	public int getASEQ() {
		return ASEQ;
	}
	public void setASEQ(int aSEQ) {
		ASEQ = aSEQ;
	}
	public String getORIGIN_PICTURE() {
		return ORIGIN_PICTURE;
	}
	public void setORIGIN_PICTURE(String oRIGIN_PICTURE) {
		ORIGIN_PICTURE = oRIGIN_PICTURE;
	}
	public String getSAVE_PICTURE() {
		return SAVE_PICTURE;
	}
	public void setSAVE_PICTURE(String sAVE_PICTURE) {
		SAVE_PICTURE = sAVE_PICTURE;
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
	public List<MultipartFile> getUpfile() {
		return upfile;
	}
	public void setUpfile(List<MultipartFile> upfile) {
		this.upfile = upfile;
	}
	
	


}
