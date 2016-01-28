package com.better.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.better.entity.ValidateBean;

/**
 * ValidateBeanMapper:Interface<br>
 * 验证dao接口，用于对用户验证并加入相关组织，部门等
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-04
 */
@Repository("validateBeanMapper")
public interface ValidateBeanMapper {
	
	/**
	 * 删除一个验证
	 * @param validateId 验证id
	 * @return
	 */
    public int deleteByPrimaryKey(Integer validateId);
    
    /**
     * 插入一个验证<br>
     * 推荐使用，如果字段为空，不插入相应字段
     * 
     * @param validateBean 验证实体Bean
     * @return
     */
    public int insertSelective(ValidateBean validateBean);
    
    /**
     * 批量插入验证信息
     * 
     * @param list
     * @return
     */
    public int insertListSelective(List<ValidateBean> list);
    
    /**
     * 查询一条验证
     * 
     * @param validateId 
     * @return
     */
    public ValidateBean selectByPrimaryKey(int validateId);
    
    /**
     * 查询验证列表<br>
     * validateBean可以塞入任意字段,获得list
     * 
     * @param validateBean 验证实体Bean
     * @return
     */
    public List<ValidateBean> selectListSelective(ValidateBean validateBean);
    
    /**
     * 更新一条验证<br>
     * 推荐使用，字段为空，不更改相应字段
     * 
     * @param validateBean 验证实体Bean
     * @return
     */
    public int updateByPrimaryKeySelective(ValidateBean validateBean);
    
    /**
     * 更新一条验证<br>
     * 
     * @param validateBean 验证实体Bean
     * @return
     */
    public int updateByPrimaryKey(ValidateBean validateBean);
}