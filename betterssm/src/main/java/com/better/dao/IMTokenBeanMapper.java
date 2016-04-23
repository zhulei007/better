package com.better.dao;

import org.springframework.stereotype.Repository;

import com.better.entity.IMTokenBean;
/**
 * 易信token相关接口
 * 
 * @author zhule_000
 *
 */
@Repository("iMTokenBeanMapper")
public interface IMTokenBeanMapper {
	/**
	 * 获取用户token
	 * @param userId
	 * @return
	 */
	public IMTokenBean select(int userId);
	/**
	 * 插入一条新用户token记录
	 * @param imTokenBean
	 * @return
	 */
	public int insert(IMTokenBean imTokenBean);
	/**
	 * 插入一条，根据字段是否为空
	 * @param imTokenBean
	 * @return
	 */
	public int insertSelective(IMTokenBean imTokenBean);
	/**
	 * 更新token
	 * @param imTokenBean
	 * @return
	 */
	public int update(IMTokenBean imTokenBean);
}
