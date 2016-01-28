package com.better.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.better.entity.UserBean;

/**
 * UserBeanMapper:Interface<br>
 * 用户dao,用于操作tab_user表
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("userBeanMapper")
public interface UserBeanMapper {
	
	/**
	 * 删除用户<br>
	 * 根据用户id
	 * 
	 * @param userId 用户id
	 * @return
	 */
    public int deleteByPrimaryKey(Integer userId);
    
    /**
     * 插入一个用户<br>
     * 
     * @param userBean 用户
     * @return
     */
    public int insert(UserBean userBean);
    
    /**
     * 插入一个用户<br>
     * 推荐使用这个方法，字段为空不插入相应字段
     * 
     * @param userBean 用户
     * @return
     */
    public int insertSelective(UserBean userBean);
    
    /**
     * 修改用户<br>
     * 推荐使用，字段为空不修改相应字段
     * 
     * @param userBean 用户
     * @return
     */
    public int updateByPrimaryKeySelective(UserBean userBean);
    
    /**
     * 修改用户<br>
     * 不推荐使用，字段为空仍会修改该字段
     * 
     * @param userBean 用户
     * @return
     */
    public int updateByPrimaryKey(UserBean userBean);
    
    /**
     * 查询用户<br>
     * 
     * @param userId 用户Id
     * @return
     */
    public UserBean selectByPrimaryKey(Integer userId);
    /**
     * 查询用户列表<br>
     * 根据userBean中存在的字段进行查询，得到匹配用户list
     * 
     * @param userBean
     * @return
     */
    public List<UserBean> selectUserListSelective(UserBean userBean);

    
}