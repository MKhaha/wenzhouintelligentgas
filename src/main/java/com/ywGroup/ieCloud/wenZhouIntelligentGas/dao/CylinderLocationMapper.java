package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;

import java.util.List;

public interface CylinderLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CylinderLocation record);

    int insertSelective(CylinderLocation record);

    CylinderLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CylinderLocation record);

    int updateByPrimaryKey(CylinderLocation record);

    CylinderLocation queryCylinderLocationByCylinderSerialNumber(String cylinderSerialNumber);

    List<CylinderLocation> queryAllCylinderLocation();
}