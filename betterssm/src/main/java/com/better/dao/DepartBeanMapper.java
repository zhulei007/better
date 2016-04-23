package com.better.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.better.entity.DepartBean;
/**
 * DepartBeanMapper:Interface<br>
 * 部门dao接口
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-07
 *
 */
@Repository("departBeanMapper")
public interface DepartBeanMapper {
	
	/**
	 * 删除<br>
	 * 根据主键
	 * 
	 * @param did 部门id
	 * @return
	 */
    public int deleteByPrimaryKey(Integer did);
    
    /**
     * 插入<br>
     * 
     * @param departBean
     * @return
     */
    public int insert(DepartBean departBean);
    
    /**
     * 插入<br>
     * 字段为空不插入相应字段
     * 
     * @param departBean
     * @return
     */
    public int insertSelective(DepartBean departBean);
    
    /**
     * 查询<br>
     * 根据部门id
     * 
     * @param did 部门id
     * @return
     */
    public DepartBean selectByPrimaryKey(Integer did);
    
    /**
     * 更新<br>
     * 推荐使用，字段为空不跟新相应字段
     * @param departBean
     * @return
     */
    public int updateByPrimaryKeySelective(DepartBean departBean);
    
    /**
     * 更新<br>
     * 字段为空仍会更新相应字段
     * 
     * @param departBean
     * @return
     */
    public int updateByPrimaryKey(DepartBean departBean);
    /**
     * 根据组织id查询所有部门
     * @param orgId
     * @return
     */
    public List<DepartBean> getListByOrgId(int orgId);
}