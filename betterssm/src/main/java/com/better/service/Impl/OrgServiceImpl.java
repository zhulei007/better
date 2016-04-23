package com.better.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.DepartBeanMapper;
import com.better.dao.OrgBeanMapper;
import com.better.dao.UserBeanMapper;
import com.better.entity.DepartBean;
import com.better.entity.OrgBean;
import com.better.entity.UserBean;
import com.better.service.OrgService;

@Service("orgService")
public class OrgServiceImpl implements OrgService {
	@Autowired
	private OrgBeanMapper orgBeanMapper;
	@Autowired
	private DepartBeanMapper departBeanMapper;
	@Autowired
	private UserBeanMapper userBeanMapper; 

	@Override
	public int addOrg(OrgBean orgBean) {
		return orgBeanMapper.insertSelective(orgBean);
	}

	@Override
	public int deleteOrg(int orgId) {

		return orgBeanMapper.deleteByPrimaryKey(orgId);
	}

	@Override
	public OrgBean updateOrg(OrgBean orgBean) {
		if(orgBean.getOid() == null ){
			return null;
		}
		int i = orgBeanMapper.updateByPrimaryKeySelective(orgBean);
		if (i >= 0) {
			return orgBeanMapper.selectByPrimaryKey(orgBean.getOid());
		}
		return null;
	}

	@Override
	public OrgBean queryOrg(int orgId) {
		
		return orgBeanMapper.selectByPrimaryKey(orgId);
	}

	@Override
	public List<OrgBean> queryQrgList(int userId) {
		List<OrgBean> list = new ArrayList<OrgBean>();
		UserBean userBean = userBeanMapper.selectByPrimaryKey(userId);
		String departIds[] = userBean.getDepartIds().split(",");
		if(departIds == null ||"".equals(departIds)){
			return null;
		}
		for(String id : departIds){
			list.add(orgBeanMapper.selectByPrimaryKey(Integer.parseInt(id)));
		}
		
		return list;
	}

	@Override
	public List<DepartBean> queryDepartList(int orgId) {
		return departBeanMapper.getListByOrgId(orgId);
	}

	@Override
	public DepartBean queryUserDepart(int orgId, int userId) {
		List<DepartBean> list = departBeanMapper.getListByOrgId(orgId);
		UserBean userBean = userBeanMapper.selectByPrimaryKey(userId);
		String departIds[] = userBean.getDepartIds().split(",");
		for(DepartBean depart : list){
			for(String id : departIds){
				if(Integer.parseInt(id)==depart.getDid()){
					return depart;
				}
			}
		}
		return null;
	}

}
