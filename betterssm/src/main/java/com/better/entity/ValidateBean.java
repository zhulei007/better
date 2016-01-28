package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class ValidateBean {
	/**
	 * 认证信息id
	 */
    private Integer validateId;
    /**
     * 组织编号id
     */
    private Integer orgid;
    /**
     * 部门编号id，只保存最低部门
     */
    private Integer depid;
    /**
     * 认证编码，这里是真正的认证信息
     */
    private String validateCode;
    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 认证状态,0:未认证，1：已认证
     */
    private Integer status;
   
    
	public Integer getValidateId() {
		return validateId;
	}
	public void setValidateId(Integer validateId) {
		this.validateId = validateId;
	}
	public Integer getOrgid() {
		return orgid;
	}
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}
	public Integer getDepid() {
		return depid;
	}
	public void setDepid(Integer depid) {
		this.depid = depid;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

   
}