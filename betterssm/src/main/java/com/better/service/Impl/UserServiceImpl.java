package com.better.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.UserBeanMapper;
import com.better.entity.UserBean;
import com.better.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBeanMapper userBeanMapper;

	@Override
	public int addUser(UserBean userBean) {
		return userBeanMapper.insertSelective(userBean);
	}

	@Override
	public int deleteUser(int userId) {
		return userBeanMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int updateUser(UserBean userBean) {
		return userBeanMapper.updateByPrimaryKeySelective(userBean);
	}

	@Override
	public boolean checkUser(UserBean userBean) {

		if (userBean == null) {
			return false;
		}
		List<UserBean> list = userBeanMapper.selectUserListSelective(userBean);
		if (list != null && list.size()==1) {
			return true;
		}
		return false;
	}

	@Override
	public UserBean queryUser(int userId) {

		return userBeanMapper.selectByPrimaryKey(userId);
	}

	@Override
	public UserBean queryUser(UserBean userBean) {
		if (userBean == null) {
			return null;
		}
		List<UserBean> list = userBeanMapper.selectUserListSelective(userBean);
		if (list != null && list.size()==1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean changePwd(UserBean userBean,String password) {
		List<UserBean> list = userBeanMapper.selectUserListSelective(userBean);
		if(list != null && list.size() == 1 ){
			userBean.setPass(password);
			userBeanMapper.updateByPrimaryKeySelective(userBean);
			return true;
		}
		return false;
	}

}
