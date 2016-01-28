package com.better.service;

import org.springframework.stereotype.Service;

import com.better.entity.UserBean;
@Service
public interface UserService {
	
	/**
	 * 添加一个用户
	 * @param user 用户
	 * @return
	 */
	public int addUser(UserBean userBean); 
	
	/**
	 * 物理删除用户<br>
	 * 
	 * @param userId
	 * @return
	 */
	public int deleteUser(int userId);
	
	/**
	 * 修改用户资料
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(UserBean userBean);
	
	/**
	 * 检查用户<br>
	 * 用于用户登录，将username，pass装入bean
	 * 
	 * @param user
	 * @return
	 */
	public boolean checkUser(UserBean userBean);
	
	/**
	 * 查询用户信息
	 * 
	 * @param userId
	 * @return 用户
	 */
	public UserBean queryUser(int userId);
	
	/**
	 * 获取用户信息<br>
	 * 根据用户填写user相应字段获取<br>
	 * 当只有一个用户匹配时才会返回该用户的详细信息
	 * @param userBean
	 * @return
	 */
	public UserBean queryUser(UserBean userBean);

}
