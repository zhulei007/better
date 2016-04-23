package com.better.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.better.entity.FriendBean;
import com.better.entity.UserBean;
/**
 * FriendService:Interface<br>
 * 朋友关系服务接口
 * 
 * @version 1.0
 * @author zhulei
 * @since 2016-01-14
 *
 */
@Service
public interface FriendService {
	/**
	 * 添加一个朋友
	 * @param friendBean
	 * @return
	 */
	public int addFriend(FriendBean friendBean);
	
	/**
	 * 查询用户的朋友列表
	 * @param userId 用户id
	 * @return
	 */
	public List<UserBean> queryFriendList(int userId);
	
	/**
	 * 接触好友关系
	 * @param friendBean
	 * @return
	 */
	public int deleteFriend(FriendBean friendBean);
}
