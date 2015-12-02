package com.better.dao;

import com.better.entity.GroupUserBeanKey;

public interface GroupUserBeanMapper {
    int deleteByPrimaryKey(GroupUserBeanKey key);

    int insert(GroupUserBeanKey record);

    int insertSelective(GroupUserBeanKey record);
}