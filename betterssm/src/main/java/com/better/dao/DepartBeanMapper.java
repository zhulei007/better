package com.better.dao;

import org.springframework.stereotype.Repository;

import com.better.entity.DepartBean;

public interface DepartBeanMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(DepartBean record);

    int insertSelective(DepartBean record);

    DepartBean selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(DepartBean record);

    int updateByPrimaryKey(DepartBean record);
}