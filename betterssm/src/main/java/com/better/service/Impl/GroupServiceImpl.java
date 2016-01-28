package com.better.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.GroupBeanMapper;
import com.better.dao.GroupUserBeanMapper;
import com.better.entity.GroupBean;
import com.better.entity.GroupUserBeanKey;
import com.better.entity.UserBean;
import com.better.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupBeanMapper groupBeanMapper;
	@Autowired
	private GroupUserBeanMapper groupUserBeanMapper;

	@Override
	public int addUser(GroupUserBeanKey groupUserBean) {
		return groupUserBeanMapper.insert(groupUserBean);
	}

	@Override
	public int releaseGroupUser(GroupUserBeanKey groupUserBean) {
		if (groupUserBean == null) {
			return 0;
		}
		return groupUserBeanMapper.deleteByPrimaryKey(groupUserBean);
	}

	@Override
	public int addGroup(GroupBean groupBean) {

		return groupBeanMapper.insertSelective(groupBean);
	}

	@Override
	public int deleteGroup(int groupId) {
		return groupBeanMapper.deleteByPrimaryKey(groupId);
	}

	@SuppressWarnings("null")
	@Override
	public GroupBean updateGroup(GroupBean groupBean) {
		if (groupBean != null || groupBean.getGtime() != null) {
			groupBean.setGtime(null);
		}
		int updateSuccessCount = groupBeanMapper.updateByPrimaryKeySelective(groupBean);
		if(updateSuccessCount==1){
			return groupBean;
		}
		return null;
	}
	@Override
	public GroupBean queryGroup(int groupId) {
		return groupBeanMapper.selectByPrimaryKey(groupId);
	}

	@Override
	public List<GroupBean> queryGroupList(int userId) {
		
		return null;
	}

	@Override
	public List<UserBean> queryUserList(int groupId) {
		return groupUserBeanMapper.selectUserList(groupId);
	}

	@Override
	public int deleteUser(GroupUserBeanKey groupUserBean) {
		
		return groupUserBeanMapper.deleteByPrimaryKey(groupUserBean);
	}

	
}
