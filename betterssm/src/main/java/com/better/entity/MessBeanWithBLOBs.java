package com.better.entity;
/**
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 */
public class MessBeanWithBLOBs extends MessBean {
	/**
	 * 信息内容
	 */
    private String content;
    /**
     * 接收人:使用逗号（英文逗号）分隔
     */
    private String receiver;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }
}