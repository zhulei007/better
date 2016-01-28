package com.better.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.MessBeanMapper;
import com.better.entity.MessBean;
import com.better.entity.MessBeanWithBLOBs;
import com.better.service.MessageService;
import com.better.service.UserMessService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessBeanMapper messMapper;
	@Autowired
	private UserMessService userMessService;

	/* 信息的删除状态：0：已删除 */
	private final static int STATUS_DELETE = 0;
	/* 信息的删除状态：1：未删除 */
	private final static int STATUS_UNDELETE = 1;

	private List<MessBeanWithBLOBs> getMessBeans() {
		return null;
	}

	@Override
	public int addMess(MessBeanWithBLOBs messBean) {
		return messMapper.insert(messBean);
	}

	@Override
	public int deleteMess(int messId) {
		return messMapper.deleteByPrimaryKey(messId);
	}

	@Override
	public int deleteMessLogic(int messId) {
		MessBean messBean = new MessBean();
		messBean.setStatus(STATUS_DELETE);
		return messMapper.updateByPrimaryKey(messBean);
	}

	@Override
	public MessBeanWithBLOBs getMessBean(int messId) {
		return messMapper.selectMessBeanWithBLOBs(messId);
	}

	@SuppressWarnings("null")
	@Override
	public void sendAllUser(List<Integer> userList, MessBean messBean) {
		if (userList != null || userList.size() >= 0) {
			for (Integer userId : userList) {
				userMessService.insertUnseen(userId, messBean);
			}
		}

	}

	@Override
	public List<MessBean> queryUnseens(int userId, int pageNo, int pageCount) {
		List<MessBean> list = new ArrayList<MessBean>();
		/* 获取该用户的未查看信息id列表 */
		List<Integer> messList = userMessService.findUnseenList(userId);
		if (messList == null || messList.size() <= 0) {
			return list;
		}
		if (messList.size() >= pageCount * pageNo) {
			for (int i = pageCount * (pageNo - 1); i < pageCount * pageNo; i++) {
				list.add(messMapper.selectMessBean(messList.get(i)));
			}
		} else {
			for(int i = pageCount * (pageNo - 1); i < messList.size(); i++){
				list.add(messMapper.selectMessBean(messList.get(i)));
			}
		}
		return list;
	}

	@Override
	public List<MessBean> querySeens(int userId, int pageNo, int pageCount) {
		List<MessBean> list = new ArrayList<MessBean>();
		/* 获取该用户的未查看信息id列表 */
		List<Integer> messList = userMessService.findSeenList(userId);
		if (messList == null || messList.size() <= 0) {
			return list;
		}
		if (messList.size() >= pageCount * pageNo) {
			for (int i = pageCount * (pageNo - 1); i < pageCount * pageNo; i++) {
				list.add(messMapper.selectMessBean(messList.get(i)));
			}
		} else {
			for(int i = pageCount * (pageNo - 1); i < messList.size(); i++){
				list.add(messMapper.selectMessBean(messList.get(i)));
			}
		}
		return list;
	}
}
