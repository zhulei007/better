package com.better.dao;

import org.springframework.stereotype.Repository;

import com.better.entity.AdminBean;
/**
 * AdminBeanMapper:Interface<br>
 * 管理员dao,用于操作tab_admin表
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("adminBeanMapper")
public interface AdminBeanMapper {
	/**
	 * 插入一条数据<br>
	 * 推荐使用，字段为空，不插入相应字段
	 * 
	 * @param adminBean 管理员Bean
	 * @return
	 */
	public int insertSelective(AdminBean adminBean);
	
	/**
	 * 删除<br>
	 * 根据编号删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
	/**
	 * 更新<br>
	 * 推荐使用，字段为空，不更新相应字段
	 * 
	 * @param adminBean
	 * @return
	 */
	public int updateByPrimaryKeySelective(AdminBean adminBean);
	
	/**
	 * 更新<br>
	 * 字段为空，仍会更新相应字段
	 * 
	 * @param adminBean
	 * @return
	 */
	public int updateByPrimaryKey(AdminBean adminBean);
	
	/**
	 * 查询一条是记录<br>
	 * 根据管理员id（用户id）
	 * 
	 * @param adminId
	 * @return
	 */
	public AdminBean select(int adminId);
	
	/**
	 * 查询一条记录<br>
	 * 根据用户的要求组成AdminBean，并根据这个Bean查询
	 * 
	 * @param adminBean
	 * @return
	 */
	//public AdminBean selectAdminSelective(AdminBean adminBean);
}
