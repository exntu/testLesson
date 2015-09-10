package com.skt.date.vo;

public class MeetVo {
	
	private String from;
	private String to;
	private String message;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MeetVo [from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
			
}
