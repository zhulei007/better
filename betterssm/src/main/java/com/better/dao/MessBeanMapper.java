package com.better.dao;

import com.better.entity.MessBean;
import com.better.entity.MessBeanWithBLOBs;

public interface MessBeanMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(MessBeanWithBLOBs record);

    int insertSelective(MessBeanWithBLOBs record);

    MessBeanWithBLOBs selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(MessBeanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MessBeanWithBLOBs record);

    int updateByPrimaryKey(MessBean record);
}