package com.better.dao;

import com.better.entity.ValidateBean;

public interface ValidateBeanMapper {
    int deleteByPrimaryKey(Integer validateId);

    int insert(ValidateBean record);

    int insertSelective(ValidateBean record);

    ValidateBean selectByPrimaryKey(Integer validateId);

    int updateByPrimaryKeySelective(ValidateBean record);

    int updateByPrimaryKey(ValidateBean record);
}