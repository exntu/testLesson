package com.skt.date.vo;

public class ProfileVo {

	private String name; //나의 이름
	private String age; //나의 나이
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ProfileVo [name=" + name + ", age=" + age + "]";
	}
	
}
