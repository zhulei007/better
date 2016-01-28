package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class MessTypeBean {
	/**
	 * 信息类型id
	 */
    private Integer tid;
    /**
     * 信息类型名称
     */
    private String tname;
    /**
     * 简介
     */
    private String memo;
    /**
     * 状态：0删除，1有效
     */
    private Short status;
    /**
     * 父级信息类型id
     */
    private Integer pid;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
   
}