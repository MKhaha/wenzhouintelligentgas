package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCar;

import java.util.List;

public interface DeliverCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverCar record);

    int insertSelective(DeliverCar record);

    List<DeliverCar> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliverCar record);

    int updateByPrimaryKey(DeliverCar record);
}