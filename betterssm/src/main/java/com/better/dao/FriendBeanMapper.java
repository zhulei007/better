package com.better.dao;

import com.better.entity.FriendBean;

public interface FriendBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FriendBean record);

    int insertSelective(FriendBean record);

    FriendBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FriendBean record);

    int updateByPrimaryKey(FriendBean record);
}