package com.better.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.FriendBeanMapper;
import com.better.entity.FriendBean;
import com.better.entity.UserBean;
import com.better.service.FriendService;
@Service("FriendService")
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendBeanMapper friendBeanMapper;
	@Override
	public int addFriend(FriendBean friendBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserBean> queryFriendList(int userId) {
		return friendBeanMapper.selectFriendList(userId);
	}

	@Override
	public int deleteFriend(FriendBean friendBean) {
		int userId = friendBean.getUid();
		int friendId = friendBean.getFid();
		FriendBean friend = new FriendBean();
		friend.setUid(userId);
		friend.setFid(friendId);
		int id = friendBeanMapper.selectByFriends(friendBean);
		return friendBeanMapper.deleteByPrimaryKey(id);
	}

}
