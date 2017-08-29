package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderSpecification;

public interface GasCylinderSpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GasCylinderSpecification record);

    int insertSelective(GasCylinderSpecification record);

    GasCylinderSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GasCylinderSpecification record);

    int updateByPrimaryKey(GasCylinderSpecification record);
}