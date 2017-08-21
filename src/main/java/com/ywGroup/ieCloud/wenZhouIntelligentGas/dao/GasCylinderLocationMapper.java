package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderLocation;

public interface GasCylinderLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GasCylinderLocation record);

    int insertSelective(GasCylinderLocation record);

    GasCylinderLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GasCylinderLocation record);

    int updateByPrimaryKey(GasCylinderLocation record);

}