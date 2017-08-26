package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DistributionCar;

public interface DistributionCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DistributionCar record);

    int insertSelective(DistributionCar record);

    DistributionCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DistributionCar record);

    int updateByPrimaryKey(DistributionCar record);
}