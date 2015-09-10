package com.skt.date.vo;

import java.util.List;

public class ProfileVo extends UploadVo{
	private String classify;
	private String data;
	
	private List<String> classify_arr;
	private List<String> data_arr;
	
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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

	public List<String> getClassify_arr() {
		return classify_arr;
	}
	public List<String> getData_arr() {
		return data_arr;
	}
	public void setClassify_arr(List<String> classify_arr) {
		this.classify_arr = classify_arr;
	}
	public void setData_arr(List<String> data_arr) {
		this.data_arr = data_arr;
	}
	@Override
	public String toString() {
		return "ProfileVo [classify=" + classify + ", data=" + data + ", classify_arr=" + classify_arr + ", data_arr="
				+ data_arr + ", email=" + email + "]";
	}


}
