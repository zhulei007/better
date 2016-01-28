package com.better.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.better.entity.MessBean;
import com.better.entity.UserMessBean;
/**
 * UserMessService:Interface<br>
 * 用户信息服务接口，用于个人或群体接收信息相关操作
 * 
 * @author zhule_000
 * @version 1.0
 * @since 2015
 */
@Service
public interface UserMessService {
	
	/*已查看信息字段标记*/
	public final static String SEEN_MESS = "seenMess";
	
	/*未查看信息字段标记*/
	public final static String UNSEEN_MESS = "unseenMess";
	
	/*已删除信息字段标记*/
	public final static String DELETE_MESS = "deleteMess";
	
	/**
	 * 增加一条用户信息关系记录<br>
	 * 每新增加一个用户，相应的就会增加一条该关系记录<br>
	 * 因为tbl_user_mess表中主键为uid(用户id)
	 * 
	 * @param userMessBean 用户信息Bean
	 * @return 成功增加数量
	 */
	public int addUserMess(UserMessBean userMessBean);
	
	/**
	 * 插入一条信息<br>
	 * 为一个用户添加一条未读信息
	 * 
	 * @param userId 用户id
	 * @param messBean
	 * @return
	 */
	public int insertUnseen(int userId, MessBean messBean);
	
	/**
	 * 删除<br>
	 * 
	 * @param userid 用户id
	 * @return
	 */
	public int deleteUserMess(int userId);
	/**
	 * 更新<br>
	 * 该方法应该是操作非常频繁的
	 * 
	 * @param userMessBean
	 * @return
	 */
	public int updateUserMess(UserMessBean userMessBean);
	
	/**
	 * 得到已查看信息数量
	 * 
	 * @param userId 用户id
	 * @return
	 */ 
	public int getCountSeen(int userId);
	
	/**
	 * 得到未查看信息数量
	 * 
	 * @param userId 用户id
	 * @return
	 */
	public int getCountUnseen(int userId);
	
	/**
	 * 得到已删除信息数量
	 * 
	 * @param userId
	 * @return
	 */
	public int getCountDelete(int userId);
	
	/**
	 * 得到已查看、未查看、已删除信息数量<br>
	 * eg:{[seen,count],[unseen,count],[delete,count]}
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Integer> getCountMess(int userId);
	
	/**
	 * 查找已查看信息id列表
	 * 
	 * @param userId用户列表
	 * @return list
	 */
	public List<Integer> findSeenList(int userId);
	
	/**
	 * 查询已未查看信息id列表
	 * 
	 * @param userId 用户id
	 * @return list
	 */
	public List<Integer> findUnseenList(int userId);
}
