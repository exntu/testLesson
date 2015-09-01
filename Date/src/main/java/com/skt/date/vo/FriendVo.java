package com.skt.date.vo;


public class FriendVo {
	private String name; //친구 이름
	private String date; //친구 등록된 날짜
	
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "FriendVo [name=" + name + ", date=" + date + "]";
	}

	
	
}
