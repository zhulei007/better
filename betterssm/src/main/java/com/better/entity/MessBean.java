package com.better.entity;

import java.util.Date;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class MessBean {
	 /**
     * 信息id，主键
     */
    private Integer mid;
	/**
	 * 信息类型id
	 */
    private Integer tid;
   
    /**
     * 标题
     */
    private String title;
    /**
     * 创建人id
     */
    private Integer uid;
    /**
     * 创建时间
     */
    private Date mtime;
    /**
     * 信息状态：0：已删除,1：有效（默认为空时也是有效的）
     */
    private Integer status;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}