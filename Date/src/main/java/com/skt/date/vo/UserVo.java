package com.skt.date.vo;

public class UserVo {

	private String id; //아이디
	private String passwd; //패스워드
	private String email; //이메일
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getEmail() {
		return email;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", passwd=" + passwd + ", email=" + email + "]";
	}
	
}
