package com.skt.date.vo;

public class CommonVo {

	private String currentTime; //현재시간
	
	private String currentDate; //현재날짜
	
	private String writer; //글쓴이

	private String updateTime; //글이 수정된 시간

	public String getCurrentTime() {
		return currentTime;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public String getWriter() {
		return writer;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "CommonVo [currentTime=" + currentTime + ", currentDate=" + currentDate + ", writer=" + writer
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
