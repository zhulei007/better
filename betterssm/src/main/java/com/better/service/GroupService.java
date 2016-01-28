package com.better.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.better.entity.GroupBean;
import com.better.entity.GroupUserBeanKey;
import com.better.entity.UserBean;

/**
 * GroupService:Interface<br>
 * 群组服务接口,用于群组操作
 * 
 * @author zhulei
 * @version 1.0
 * @since 2015
 */
@Service
public interface GroupService {
	
	/**
	 * 给组织添加一个用户
	 * 
	 * @param groupUserBean
	 * @return
	 */
	public int addUser(GroupUserBeanKey groupUserBean);
	
	/**
	 * 物理删除云用户
	 * @param groupUserBean 群用户关系
	 * @return
	 */
	public int deleteUser(GroupUserBeanKey groupUserBean);
	
	/**
	 * 解除用户和组织的关系<br>
	 * 
	 * @param groupUserBean
	 * @return
	 */
	public int releaseGroupUser(GroupUserBeanKey groupUserBean);
	
	/**
	 * 添加一个组织
	 * @param groupBean
	 * @return
	 */
	public int addGroup(GroupBean groupBean);
	
	/**
	 * 解散组织<br>
	 * 删除组织
	 * @param ggroupId
	 * @return
	 */
	public int deleteGroup(int groupId);
	
	/**
	 * 更新群组信息<br>
	 * 群组创建时间应该是不能更新的
	 * 
	 * @param groupBean
	 * @return
	 */
	public GroupBean updateGroup(GroupBean groupBean);
	
	/**
	 * 查询群组信息<br>
	 * 根据群组id
	 * @param groupId
	 * @return
	 */
	public GroupBean queryGroup(int groupId);
	
	/**
	 * 查询用户所在群组list
	 * 
	 * @param userId 用户id
	 * @return
	 */
	public List<GroupBean> queryGroupList(int userId);
	
	/**
	 * 查询群组中所有组员列表
	 * 
	 * @param GroupId 群组id
	 * @return
	 */
	public List<UserBean> queryUserList(int groupId);
	
	
}
