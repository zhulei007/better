package com.better.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.better.entity.FriendBean;
import com.better.entity.UserBean;
/**
 * FriendBeanMapper:Interface<br>
 * 朋友dao
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("friendBeanMapper")
public interface FriendBeanMapper {
	
	/**
	 * 删除<br>
	 * 根据记录编号id
	 * 
	 * @param id
	 * @return
	 */
    public int deleteByPrimaryKey(Integer id);
    /**
     * 插入一条记录
     * @param friendBean 朋友关系bean
     * @return
     */
    public int insert(FriendBean friendBean);
    
    /**
     * 插入<br>
     * 根据字段，选择性插入数据<br>
     * 这个方法可能用不到，毕竟friendBean只有两个字段
     * 
     * @param friendBean
     * @return
     */
    public int insertSelective(FriendBean friendBean);
    
    /**
     * 查询<br>
     * 根据记录编号查询<br>
     * 这个接口没什么用，没有人会事先知道记录编号
     * @param id
     * @return
     */
    public FriendBean selectByPrimaryKey(Integer id);
    /**
     * 更新朋友记录<br>
     * 根据friendBean字段
     * @param friendBean
     * @return
     */
    public int updateByPrimaryKeySelective(FriendBean friendBean);
    /**
     * 更新<br>
     * 无论字段是否存在都会更新
     * @param friendBean
     * @return
     */
    public int updateByPrimaryKey(FriendBean friendBean);
    
    /**
     * 查询好友列表
     * @param userId
     * @return
     */
    public List<UserBean> selectFriendList(int userId);
}