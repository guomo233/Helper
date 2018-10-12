package com.helper.pojo;

public class User {

	private int  finishTimes ;
	private String username, password, phone, sex ;
	private float evaluate ;
	public int getFinishTimes() {
		return finishTimes;
	}
	public void setFinishTimes(int finishTimes) {
		this.finishTimes = finishTimes;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public float getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(float evaluate) {
		this.evaluate = evaluate;
	}
}
