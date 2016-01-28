package com.better.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.better.entity.MessTypeBean;
/**
 * MessTypeBeanMapper:Interface<br>
 * 信息类型dao
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("messTypeBeanMapper")
public interface MessTypeBeanMapper {
	/**
	 * 根据主键删除类型
	 * @param tid 类型id
	 * @return 成功数量
	 */
    int deleteByPrimaryKey(Integer tid);
    /**
     * 更新一条信息类型
     * @param record 信息类型
     * @return 成功数量
     */
    int updateByPrimaryKeySelective(MessTypeBean record);
    /**
     * 更新一条信息类型
     * @param record 信息类型
     * @return
     */
    int updateByPrimaryKey(MessTypeBean record);
    /**
     * 添加一条类型
     * @param record 信息类型Bean
     * @return 成功数量
     */
    int insert(MessTypeBean record);
    /**
     * 添加一条类型（和insert的差别？）
     * @param record 信息类型
     * @return 成功数量
     */
    int insertSelective(MessTypeBean record);
    /**
     * 查询一个类型
     * @param tid 类型id
     * @return MessTypeBean
     */
    public MessTypeBean selectByPrimaryKey(Integer tid);
    
    /**
     * 获取所有的信息类型list
     * @return
     */
    public List<MessTypeBean> selectList();
   
}