package com.skt.date.vo;

public class QuestionVo {
	private int num; //FAQ 번호
	private String title; //FAQ 제목
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "QuestionVo [num=" + num + ", title=" + title + "]";
	}
	
}
