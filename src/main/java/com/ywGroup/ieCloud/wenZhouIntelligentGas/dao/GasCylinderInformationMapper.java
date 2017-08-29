package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderInformation;

public interface GasCylinderInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GasCylinderInformation record);

    int insertSelective(GasCylinderInformation record);

    GasCylinderInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GasCylinderInformation record);

    int updateByPrimaryKey(GasCylinderInformation record);
}