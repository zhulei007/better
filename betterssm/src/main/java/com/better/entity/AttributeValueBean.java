package com.better.entity;

public class AttributeValueBean {
	/**
	 * 编号
	 */
	private int id ;
	/**
	 * 属性id
	 */
	private int attributeId;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 属性值
	 */
	private String value;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AttributeValueBean [id=" + id + ", attributeId=" + attributeId
				+ ", userId=" + userId + ", value=" + value + "]";
	}

}
