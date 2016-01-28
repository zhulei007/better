package com.better.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.better.entity.GroupUserBeanKey;
import com.better.entity.UserBean;
/**
 * GroupUserBeanMapper:Interface<br>
 * 用户-群组dao
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("groupUserBeanMapper")
public interface GroupUserBeanMapper {
	
	/**
	 * 删除用户-组织关系
	 * @param groupUserBeanKey 用户-组织关系
	 * @return 删除数量
	 */
    public int deleteByPrimaryKey(GroupUserBeanKey groupUserBeanKey);
    /**
     * 插入一条记录
     * @param groupUserBeanKey 用户-组织关系
     * @return
     */
    public int insert(GroupUserBeanKey groupUserBeanKey);
    
    /**
     * 插入一条记录<br>
     * 字段可以为空<br>
     * 不推荐使用，毕竟只有两个字段
     * @param groupUserBeanKey
     * @return
     */
    public int insertSelective(GroupUserBeanKey groupUserBeanKey);
    
    /**
     * 查询群组所有用户<br>
     * 根据群组id
     * @param groupId 群组id
     * @return
     */
    public List<UserBean> selectUserList(int groupId);
}