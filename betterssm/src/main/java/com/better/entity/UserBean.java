package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class UserBean {
	/**
	 * 用户id
	 */
    private Integer uid;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 密码
     */
    private String pass;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 组织管理员标示
     */
    private Short isAdmin;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Short getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Short isAdmin) {
        this.isAdmin = isAdmin;
    }


	@Override
	public String toString() {
		return "UserBean [uid=" + uid + ", username=" + username + ", pass="
				+ pass + ", email=" + email + ", mobile=" + mobile
				+ ", status=" + status + ", isAdmin=" + isAdmin + "]";
	}
    
}