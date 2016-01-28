package com.better.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.better.entity.MessBean;
import com.better.entity.MessBeanWithBLOBs;
import com.better.entity.UserBean;
/**
 * MessageService:Interface<br>
 * 信息服务接口,用于信息相关服务操作
 * 
 * @author zhulei
 * @version 1.0
 * @since 2015
 */
@Service
public interface MessageService {
	
	/**
	 * 新增一条信息
	 * 
	 * @return 数量
	 */
	public int addMess(MessBeanWithBLOBs messBean);
	
	/** 
	 * 删除一条信息<br>
	 * 物理删除
	 * 
	 * @return 数量
	 */
	public int deleteMess(int messId);
	
	/**
	 * 逻辑删除<br>
	 * 将status字段设置为0，即删除
	 * @param messId
	 * @return
	 */
	public int deleteMessLogic(int messId);
	/**
	 * 获得一条信息<br>
	 * 获得信息的完整记录（包括了信息的内容）
	 * @param id 信息id
	 * @return 信息
	 */
	public MessBeanWithBLOBs getMessBean(int messId);
	
	/**
	 * 群发一条消息<br>
	 * 群发消息是将消息存入所有收件人的数据库，故不再有返回值
	 * 
	 * @param userList 用户Id列表
	 * @param mess 消息
	 * @return 成功数量
	 */
	public void sendAllUser(List<Integer> userList, MessBean mess);
	
	/**
	 * 查询未阅读消息<br>
	 * 根据用户id查询，需要分页
	 * 
	 * @param userId 用户id
	 * @param pageNo 查询页码
	 * @param pageCount 单页查询数量
	 * @return
	 */
	public List<MessBean> queryUnseens(int userId, int pageNo, int pageCount);
	
	/**
	 * 查询已阅读消息<br>
	 * 根据用户id查询，需要分页
	 * 
	 * @param userId 用户id
	 * @param pageNo 查询页码
	 * @param pageCount 单页查询数量
	 * @return
	 */
	public List<MessBean> querySeens(int userId, int pageNo, int pageCount);
}
