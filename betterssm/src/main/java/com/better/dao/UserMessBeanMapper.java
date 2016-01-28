package com.better.dao;

import org.springframework.stereotype.Repository;

import com.better.entity.UserMessBean;
/**
 * UserMessBeanMapper:Interface<br>
 * 用户-信息dao
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("userMessBeanMapper")
public interface UserMessBeanMapper {
	
	/**
	 * 插入一条<br>
	 * 当用户注册成功后，同时执行
	 * 
	 * @param userMessBean
	 * @return
	 */
	public int insertUserMess(UserMessBean userMessBean);
	
	/**
	 * 删除<br>
	 * 根据用户id删除，当用户被删除，该记录也被删除
	 * 
	 * @param userId 用户
	 * @return 删除数量
	 */
	public int deleteUSerMess(int userId);
	
	/**
	 * 更新一条记录
	 * 
	 * @param userMessBean 用户-信息映射Bean
	 * @return 更新数量
	 */
	public int updateUserMess(UserMessBean userMessBean); 
	
	/**
	 * 
	 * 查询用户信息记录
	 * @param userId 用户id
	 * @return userMessBean
	 */
	public UserMessBean selectUserMess(int userId);
	
	
	
	
}
