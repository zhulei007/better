package com.better.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.dao.ValidateBeanMapper;
import com.better.entity.ValidateBean;
import com.better.service.ValidateService;

@Service("validateService")
public class ValidateServiceImpl implements ValidateService {
	
	@Autowired
	private ValidateBeanMapper validateBeanMapper;

	@Override
	public int deleteValidate(ValidateBean validateBean) {
		/*首先根据验证Bean获取记录，得到id*/
		List<ValidateBean> list = validateBeanMapper.selectListSelective(validateBean);
		if(list != null && list.size() == 1){
			return validateBeanMapper.deleteByPrimaryKey(list.get(0).getValidateId());
		}
		return 0;
	}

	@Override
	public int deleteValidateById(int validateId) {
		return validateBeanMapper.deleteByPrimaryKey(validateId);
	}

	@Override
	public int updateValidate(ValidateBean validateBean) {
		return validateBeanMapper.updateByPrimaryKey(validateBean);
	}

	@Override
	public int addValidate(ValidateBean validateBean) {
		return validateBeanMapper.insertSelective(validateBean);
	}

	@Override
	public int addValidateList(List<ValidateBean> list) {
		if(list == null || list.size() <= 0){
			return 0;
		}
		return validateBeanMapper.insertListSelective(list);
	}

}
