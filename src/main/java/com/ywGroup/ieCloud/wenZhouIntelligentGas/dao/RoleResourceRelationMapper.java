package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.RoleResourceRelation;

import java.util.List;

public interface RoleResourceRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    RoleResourceRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);

    List<String> selectByRoleNumber(String roleNumber);
}