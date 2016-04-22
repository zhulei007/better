package com.better.entity;

public class AttributeBean {

	/**
	 * 属性id
	 */
	private int attributeId;
	/**
	 * 属性名称
	 */
	private String attributeName;
	/**
	 * 状态,目前一切操作不考虑状态<br>
	 * 删除操作只要名称或id匹配即可删除
	 */
	private int status;
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AttributeBean [attributeId=" + attributeId + ", attributeName="
				+ attributeName + ", status=" + status + "]";
	}
	
}
