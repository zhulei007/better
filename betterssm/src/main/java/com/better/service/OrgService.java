package com.better.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.better.entity.DepartBean;
import com.better.entity.OrgBean;

/**
 * OrgService:Interface<br>
 * 组织服务接口,组织部门也在这里处理
 * 
 * @author zhulei
 * @version 1.0
 * @since 2015-01-18
 *
 */
@Service
public interface OrgService {
	/**
	 * 添加一个组织
	 * 
	 * @param orgBean 
	 * @return int
	 */
	public int addOrg(OrgBean orgBean);
	
	/**
	 * 删除一个组织
	 * 
	 * @param orgId 组织id
	 * @return
	 */
	public int deleteOrg(int orgId);
	
	/**
	 * 修改组织信息
	 * 
	 * @param orgBean
	 * @return OrgBean
	 */
	public OrgBean updateOrg(OrgBean orgBean);
	
	/**
	 * 查询一个组织
	 * @param orgId 组织id
	 * @return OrgBean
	 */
	public OrgBean queryOrg(int orgId);
	
	/**
	 * 查询一个用户的所有组织list
	 * 
	 * @param userId 用户id
	 * @return list
	 */
	public List<OrgBean> queryQrgList(int userId);
	/**
	 * 查询某组织下所有的部门列表
	 * 
	 * @param orgId 组织id
	 * @return
	 */
	public List<DepartBean> queryDepartList(int orgId);
	/**
	 * 查询用户在某个组织中的所属部门
	 * @param orgId 组织id
	 * @param userId 用户id
	 * @return
	 */
	public DepartBean queryUserDepart(int orgId,int userId);
}
