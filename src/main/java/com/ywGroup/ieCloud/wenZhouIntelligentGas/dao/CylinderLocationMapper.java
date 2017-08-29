package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;

public interface CylinderLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CylinderLocation record);

    int insertSelective(CylinderLocation record);

    CylinderLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CylinderLocation record);

    int updateByPrimaryKey(CylinderLocation record);

    CylinderLocation checkByCylinderSerialNumber(String cylinderSerialNumber);
}