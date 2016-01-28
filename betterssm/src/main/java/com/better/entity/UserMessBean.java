package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class UserMessBean {
	
	/**
	 * 用户id
	 */
	private Integer uid;
	
	/**
	 * 已查看信息id<br>
	 * 以逗号分开 
	 */
	private String seenids;
	
	/**
	 * 未查看信息id<br>
	 * 以逗号分开
	 */
	private String unseenids;
	
	/**
	 * 删除信息id<br>
	 * 以逗号分开
	 */
	private String deleteids;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getSeenids() {
		return seenids;
	}

	public void setSeenids(String seenids) {
		this.seenids = seenids;
	}

	public String getUnseenids() {
		return unseenids;
	}

	public void setUnseenids(String unseenids) {
		this.unseenids = unseenids;
	}

	public String getDeleteids() {
		return deleteids;
	}

	public void setDeleteids(String deleteids) {
		this.deleteids = deleteids;
	}
	
	
	

}
