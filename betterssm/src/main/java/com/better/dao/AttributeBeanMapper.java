package com.better.dao;

import com.better.entity.AttributeBean;
/**
 * 属性实体操作接口<br>
 * 暂时不考虑更新操作
 * @author zhule_000
 *
 */
public interface AttributeBeanMapper {
	/**
	 * 插入一个属性，对象中只要含有属性名即可
	 * @param attributeBean
	 * @return
	 */
	public int insertSelective(AttributeBean attributeBean);
	/**
	 * 删除<br>
	 * 对象中只要有一个字段不为空，即可删除
	 * @param AttributeId
	 * @return
	 */
	public int deleteSelective(int attributeId);
	/**
	 * 根据属性id查询属性名称
	 * @param attributeId
	 * @return
	 */
	public AttributeBean selectAttributeBean(int attributeId);
	
}
