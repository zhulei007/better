package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class OrgBean {
	
	/**
	 * 组织id
	 */
    private Integer oid;
    /**
     * 组织名称
     */
    private String oname;
    /**
     * 标志：可以是副标题，也可直接保存标志图片链接（长度为100）
     */
    private String logo;
    /**
     * 组织附件
     */
    private String ofile;
    /**
     * 组织描述
     */
    private String descipt;
    /**
     * 组织状态
     */
    private Short status;
    /**
     * 组织管理员id：暂时保存超级管理员id
     */
    private Integer uid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getOfile() {
        return ofile;
    }

    public void setOfile(String ofile) {
        this.ofile = ofile == null ? null : ofile.trim();
    }

    public String getDescipt() {
        return descipt;
    }

    public void setDescipt(String descipt) {
        this.descipt = descipt == null ? null : descipt.trim();
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
}