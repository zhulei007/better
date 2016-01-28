package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class FriendBean {
	/**
	 * 编号
	 */
    private Integer id;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 朋友id
     */
    private Integer fid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
}