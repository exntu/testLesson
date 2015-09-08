package com.skt.date.vo;

import java.util.Arrays;

public class ProfileVo extends UploadVo{
	private String classify;
	private String data;
	public String getClassify() {
		return classify;
	}
	public String getData() {
		return data;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ProfileVo [classify=" + classify + ", data=" + data + "]";
	}

}
