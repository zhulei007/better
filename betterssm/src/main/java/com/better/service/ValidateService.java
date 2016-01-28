package com.better.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.better.entity.ValidateBean;

@Service
public interface ValidateService {
	/**
	 * 删除一个验证信息
	 * @return
	 */
	public int deleteValidate(ValidateBean validateBean);
	
	/**
	 * 根据验证id删除
	 * 
	 * @param validateId 验证信息id
	 * @return
	 */
	public int deleteValidateById(int validateId);
	/**
	 * 更新一个验证信息
	 * @param validateBean 验证信息
	 * @return
	 */
	public int updateValidate(ValidateBean validateBean);
	
	/**
	 * 增加一条验证信息
	 * @param validateBean 验证信息
	 * @return
	 */
	public int addValidate(ValidateBean validateBean);
	
	/**
	 * 批量增加验证信息
	 * @param list
	 * @return
	 */
	public int addValidateList(List<ValidateBean> list);
	
}
