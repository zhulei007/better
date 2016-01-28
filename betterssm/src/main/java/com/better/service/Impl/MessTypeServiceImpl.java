package com.better.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.MessTypeBeanMapper;
import com.better.entity.MessTypeBean;
import com.better.service.MessTypeService;
@Service("messTypeService")
public class MessTypeServiceImpl implements MessTypeService {
	@Autowired
	private MessTypeBeanMapper messTypeBeanMapper;
	
	/*信息类型被删除的标记:有效*/
	private final static short STATUS_RIGHT= 1;
	/*信息类型被删除的标记:已删除*/
	private final static short STATUS_FALSE = 0;

	@Override
	public int addMessType(MessTypeBean messType) {
		return messTypeBeanMapper.insert(messType);
	}

	@Override
	public int deleteMessType(MessTypeBean messType) {
		/*像这种类型表不应该设置删除操作，单为了在没有开发人员的情况下，还是添加此功能
		   使用逻辑删除*/
		
		/*将状态改为删除*/
		messType.setStatus(STATUS_FALSE);
		return messTypeBeanMapper.updateByPrimaryKey(messType);
	}

	@Override
	public List<MessTypeBean> selectMessTypes() {
		return messTypeBeanMapper.selectList();
	}

	@Override
	public MessTypeBean getMessType(int id) {
		return messTypeBeanMapper.selectByPrimaryKey(id);
	}
}
