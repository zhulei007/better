package com.better.dao;

import java.util.List;

import com.better.entity.AttributeValueBean;

/**
 * 属性值操作接口<br>
 * 目前暂时不考虑联合查询
 * @author zhule_000
 *
 */
public interface AttributeValueBeanmMapper {
	/**
	 * 插入一个属性值<br>
	 * 对象所有字段都不能为空
	 * @param attributeValue
	 * @return
	 */
	public int insert(AttributeValueBean attributeValue);
	/**
	 * 删除一个属性值<br>
	 * 对象必须且只能包含属性id和用户id
	 * @param attributeValue
	 * @return
	 */
	public int delete(AttributeValueBean attributeValue);
	/**
	 * 更新一个属性值<br>
	 * 对象所有字段都不能为空
	 * @param attributeValue
	 * @return
	 */
	public int update(AttributeValueBean attributeValue);
	/**
	 * 获取某用户属性值<br>
	 * 根据用户id和属性id来获取
	 * @param attributeValue
	 * @return
	 */
	public AttributeValueBean selectValue(AttributeValueBean attributeValue);
	/**
	 * 获取某用户的所有属性值<br>
	 * 该用户下的所有属性的属性值
	 * @param arrtributeValue
	 * @return
	 */
	public List<AttributeValueBean> selectValueList(int userId);


}
