package com.better.dao;

import org.springframework.stereotype.Repository;

import com.better.entity.OrgBean;

/**
 * OrgBeanMapper:Interface<br>
 * 组织dao接口
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-05
 *
 */
@Repository("orgBeanMapper")
public interface OrgBeanMapper {
	/**
	 * 删除一个组织
	 * 
	 * @param oid 组织id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer oid);

	/**
	 * 插入一个组织
	 * 
	 * @param orgBean 组织实体Bean
	 * @return
	 */
	public int insert(OrgBean orgBean);

	/**
	 * 插入一个组织<br>
	 * 字段为空，不插入相应字段
	 * 
	 * @param orgBean 组织实体Bean
	 * @return
	 */
	public int insertSelective(OrgBean orgBean);

	/**
	 * 查询一个组织
	 * 
	 * @param oid 组织id
	 * @return
	 */
	public OrgBean selectByPrimaryKey(Integer oid);

	/**
	 * 更新组织信息<br>
	 * 推荐使用，字段为空不更新相应字段
	 * @param orgBean 组织实体Bean
	 * @return
	 */
	public int updateByPrimaryKeySelective(OrgBean orgBean);
	/**
	 * 更新组织信息<br>
	 * 字段为空，则将原数据库记录更新为空
	 * @param orgBean 组织实体Bean
	 * @return
	 */
	public int updateByPrimaryKey(OrgBean orgBean);
}