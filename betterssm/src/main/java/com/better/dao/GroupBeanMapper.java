package com.better.dao;

import com.better.entity.GroupBean;

public interface GroupBeanMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(GroupBean record);

    int insertSelective(GroupBean record);

    GroupBean selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(GroupBean record);

    int updateByPrimaryKey(GroupBean record);
}