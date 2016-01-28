package com.better.dao;

import org.springframework.stereotype.Repository;

import com.better.entity.GroupBean;
/**
 * GroupBeanMapper：Interface<br>
 * 群组dao接口
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("groupBeanMapper")
public interface GroupBeanMapper {
	
	/**
	 * 删除<br>
	 * 根据群组id
	 * 
	 * @param gid
	 * @return
	 */
    public int deleteByPrimaryKey(Integer gid);
    
    /**
     * 插入<br>
     * 插入一条群组记录
     * 
     * @param groupBean
     * @return
     */
    public int insert(GroupBean groupBean);
    
    /**
     * 插入<br>
     * 允许有空字段
     * 
     * @param groupBean
     * @return
     */
    public int insertSelective(GroupBean groupBean);

    /**
     * 查询群组信息<br>
     * 根据群组id
     * 
     * @param gid
     * @return
     */
    public GroupBean selectByPrimaryKey(Integer gid);

    /**
     * 更新群组信息<br>
     * 允许空字段，字段为空，不更新相应内容
     * 
     * @param groupBean
     * @return
     */
    public int updateByPrimaryKeySelective(GroupBean groupBean);
    /**
     * 更新群组信息<br>
     * 不允许有空字段，空字段将会更新到数据库
     * @param groupBean
     * @return
     */
    public int updateByPrimaryKey(GroupBean groupBean);
}