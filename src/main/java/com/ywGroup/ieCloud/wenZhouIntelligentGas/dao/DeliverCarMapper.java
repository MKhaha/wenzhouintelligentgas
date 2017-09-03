package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliverCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverCar record);

    int insertSelective(DeliverCar record);

    DeliverCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliverCar record);

    int updateByPrimaryKey(DeliverCar record);

    List<DeliverCar> selectAllById(@Param("id") Integer id);
}