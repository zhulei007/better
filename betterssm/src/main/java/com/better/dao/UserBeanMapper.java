package com.better.dao;

import com.better.entity.UserBean;

public interface UserBeanMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}