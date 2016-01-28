package com.better.entity;

import java.util.Date;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class GroupBean {

	/**
	 * 群组id
	 */
    private Integer gid;
    /**
     * 群组名称
     */
    private String gname;
    /**
     * 群组简介
     */
    private String memo;
    /**
     * 群组状态
     */
    private Short status;
    /**
     * 管理员id:群组只有一个管理员，因此保存在这里
     */
    private Integer uid;
    /**
     * 创建时间
     */
    private Date gtime;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }
}