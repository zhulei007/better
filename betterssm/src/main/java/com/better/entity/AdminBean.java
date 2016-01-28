package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class AdminBean {
	/**
	 * 编码
	 */
	private int id;
	/**
	 * 组织id
	 */
	private int orgId;
	/**
	 * 部门id
	 */
	private int depId;
	/**
	 * 管理员id，关联用户id
	 */
	private int adminId;
	/**
	 * 等级，99：超级管理员，以此类推
	 */
	private int rank;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
