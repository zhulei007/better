package com.better.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.UserMessBeanMapper;
import com.better.entity.MessBean;
import com.better.entity.UserMessBean;
import com.better.service.UserMessService;
@Service("userMessService")
public class UserMessServiceImpl implements UserMessService {
	
	@Autowired
	private UserMessBeanMapper userMessBeanMapper;

	@Override
	public int addUserMess(UserMessBean userMessBean) {
		return userMessBeanMapper.insertUserMess(userMessBean);
	}
	
	@Override
	public int insertUnseen(int userId, MessBean messBean) {
		UserMessBean userMessBean = userMessBeanMapper.selectUserMess(userId);
		if(messBean == null){
			return 0;
		}
		
		if(userMessBean == null){
			UserMessBean userMess = new  UserMessBean();
			userMess.setUid(userId);
			userMess.setUnseenids(String.valueOf(messBean.getMid()));
			/*用户-信息表没有记录，执行插入操作*/
			return userMessBeanMapper.insertUserMess(userMess);
		}else{
			String unseen = userMessBean.getUnseenids();
			if(unseen==null||"".equals(unseen)){
				userMessBean.setUnseenids(String.valueOf(messBean.getMid()));
				/*用户-信息表有记录，但未读信息字段为空，执行更新操作*/
				return userMessBeanMapper.updateUserMess(userMessBean);
			}else{
				unseen = unseen + "," +messBean.getMid();
				/*用户-信息表有记录，且未读信息字段不为空，执行更新操作*/
				return userMessBeanMapper.updateUserMess(userMessBean);
			}
		}
	}
	@Override
	public int deleteUserMess(int userId) {

		return userMessBeanMapper.deleteUSerMess(userId);
	}

	@Override
	public int updateUserMess(UserMessBean userMessBean) {

		return userMessBeanMapper.updateUserMess(userMessBean);
	}

	@Override
	public int getCountSeen(int userId) {
		UserMessBean userMessBean = userMessBeanMapper.selectUserMess(userId);
		if(userMessBean == null){
			return 0;
		}
		String seenMess = userMessBean.getSeenids();
		if(seenMess == null || "".equals(seenMess)){
			
		}
		String[] seens = seenMess.split(",");
		return seens.length;
	}

	@Override
	public int getCountUnseen(int userId) {
		UserMessBean userMessBean = userMessBeanMapper.selectUserMess(userId);
		if(userMessBean == null){
			return 0;
		}
		String unseenMess = userMessBean.getUnseenids();
		if(unseenMess == null || "".equals(unseenMess)){
			return 0;
		}
		String[] unseens = unseenMess.split(",");
		return unseens.length;
	}

	@Override
	public int getCountDelete(int userId) {
		UserMessBean userMessBean = userMessBeanMapper.selectUserMess(userId);
		if(userMessBean == null){
			return 0;
		}
		String deleteMess = userMessBean.getDeleteids();
		if(deleteMess == null ||"".equals(deleteMess)){
			return 0;
		}
		String[] deletes = deleteMess.split(",");
		return deletes.length;
	}

	@Override
	public Map<String, Integer> getCountMess(int userId) {

		UserMessBean userMessBean = userMessBeanMapper.selectUserMess(userId);

		if (userMessBean == null) {
			return null;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		String seenMess = userMessBean.getSeenids();
		String unseenMess = userMessBean.getUnseenids();
		String deleteMess = userMessBean.getDeleteids();
   
		if (seenMess == null || "".equals(seenMess)) {
			map.put(SEEN_MESS, seenMess.split(",").length);
		}
		if (unseenMess == null || "".equals(unseenMess)) {
			map.put(UNSEEN_MESS, unseenMess.split(",").length);
		}
		if (deleteMess == null || "".equals(deleteMess)) {
			map.put(DELETE_MESS, deleteMess.split(",").length);
		}
		return map;
	}

	@SuppressWarnings("null")
	@Override
	public List<Integer> findSeenList(int userId) {
		UserMessBean userMessBean = userMessBeanMapper.selectUserMess(userId);
		List<Integer> list = null;

		if (userMessBean == null) {
			return null;
		}
		String seenMess = userMessBean.getSeenids();
		if (seenMess == null || "".equals(seenMess)) {
			for(String str: seenMess.split(",")){
				list.add(Integer.parseInt(str));
			}
		}
		return list;
	}

	@SuppressWarnings("null")
	@Override
	public List<Integer> findUnseenList(int userId) {
		UserMessBean userMessBean = userMessBeanMapper.selectUserMess(userId);
		List<Integer> list = null;

		if (userMessBean == null) {
			return null;
		}
		String unseenMess = userMessBean.getUnseenids();
		if (unseenMess == null || "".equals(unseenMess)) {
			for(String str: unseenMess.split(",")){
				list.add(Integer.parseInt(str));
			}
		}
		return list;
	}

	

}
