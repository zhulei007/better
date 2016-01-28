package com.better.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.better.entity.MessTypeBean;
/**
 * MessTypeService:Interface<br>
 * 信息类型服务接口,用于信息类型相关的服务操作
 * 
 * @author zhulei
 * @version 1.0
 * @since 2015
 */

@Service
public interface MessTypeService {
	
	/**
	 * 添加一个信息类型
	 * @param messType 信息类型
	 * @return 添加成功记录数量
	 */
	public int addMessType(MessTypeBean messType);
	
	/**
	 * 根据id删除一个信息类型<br>
	 * @param id 信息类型id
	 * @return 删除数量
	 */
	public int deleteMessType(MessTypeBean messType);
	/**
	 * 查询所有信息类型
	 * @return
	 */
	public List<MessTypeBean> selectMessTypes();
	
	/**
	 * 查找类型
	 * @param id 类型id
	 * @return 类型
	 */
	public MessTypeBean getMessType(int id);
}
