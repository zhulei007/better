package com.better.dao;

import com.better.entity.MessTypeBean;

public interface MessTypeBeanMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(MessTypeBean record);

    int insertSelective(MessTypeBean record);

    MessTypeBean selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(MessTypeBean record);

    int updateByPrimaryKey(MessTypeBean record);
}