package com.helper.pojo;

import java.util.Date;

public class Massage {
	
	private Massage () {}

	private int massageId ;
	private String title, content, senderUsername, targetUsername ;
	private Date sendTime ;
	private boolean isSkimed ;
	public int getMassageId() {
		return massageId;
	}
	public void setMassageId(int massageId) {
		this.massageId = massageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public boolean isSkimed() {
		return isSkimed;
	}
	public void setSkimed(boolean isSkimed) {
		this.isSkimed = isSkimed;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSenderUsername() {
		return senderUsername;
	}
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}
	public String getTargetUsername() {
		return targetUsername;
	}
	public void setTargetUsername(String targetUsername) {
		this.targetUsername = targetUsername;
	}
	
	public static Massage getEmptyMassage () {
		return new Massage () ;
	}
	
	public static Massage getSystemNotifyMassage () {
		Massage massage = new Massage () ;
		massage.setTitle("系统通知");
		massage.setSenderUsername("Admin");
		return massage ;
	}
}
