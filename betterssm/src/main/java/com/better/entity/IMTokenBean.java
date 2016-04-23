package com.better.entity;

public class IMTokenBean {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 用户id与im的accid对应
	 */
	private int userId;
	/**
	 * IM的token码
	 */
	private String token;
	 /**
	  * 状态码,暂时不考虑
	  */
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "IMTokenBean [id=" + id + ", userId=" + userId + ", token="
				+ token + ", status=" + status + "]";
	}
	
}
