package com.focus.board.model;

public class ReboardDto extends BoardDto{
	

	private int rseq;// �Ϸù�ȣ
	private int ref;// �׷��ȣ 
	private int lev;// �鿩����
	private int step;// �������
	private int pseq;// ���۹�ȣ
	private int reply;// ��۰���
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	

}
