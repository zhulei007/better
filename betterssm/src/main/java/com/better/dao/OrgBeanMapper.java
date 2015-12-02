package com.better.dao;

import com.better.entity.OrgBean;

public interface OrgBeanMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(OrgBean record);

    int insertSelective(OrgBean record);

    OrgBean selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(OrgBean record);

    int updateByPrimaryKey(OrgBean record);
}