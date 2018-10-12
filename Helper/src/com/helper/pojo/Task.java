package com.helper.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
	
	public static final int WAIT_RECEIVE = 0, ING = 1, FINISHED = 2 ;
	
	private int taskId, status ;
	private String city, beginPosition, endPosition, remark, demand, receiveUsername, releaseUsername ;
	private Date beginTime, endTime, updateTime ;
	private double pay ;
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBeginPosition() {
		return beginPosition;
	}
	public void setBeginPostion(String beginPosition) {
		this.beginPosition = beginPosition;
	}
	public String getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(String endPosition) {
		this.endPosition = endPosition;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDemand() {
		return demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public String getDemandAbstract () {
		int demandLength = demand.length() ;
		if (demandLength < 10)
			return demand.substring(0, demandLength) ;
		else
			return demand.substring(0, 10) + "..." ;
	}
	public String getReceiveUsername() {
		return receiveUsername;
	}
	public void setReceiveUsername(String receiveUsername) {
		this.receiveUsername = receiveUsername;
	}
	public String getReleaseUsername() {
		return releaseUsername;
	}
	public void setReleaseUsername(String releaseUsername) {
		this.releaseUsername = releaseUsername;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
