package com.skt.date.vo;

public class CardVo {

	//상대방의 이름
	private String name;
	
	//상대방의 나이
	private String age;
	
	//상대방의 직업
	private String job;
	
	//상대방의 성별
	private char sex;
	
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getJob() {
		return job;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "CardVo [name=" + name + ", age=" + age + ", job=" + job + ", sex=" + sex + "]";
	}

	

			
}
