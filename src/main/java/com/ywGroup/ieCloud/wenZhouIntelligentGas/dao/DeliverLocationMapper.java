package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverLocation;
import org.apache.ibatis.annotations.Param;



public interface DeliverLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverLocation record);

    int insertSelective(DeliverLocation record);

    DeliverLocation selectByPrimaryKey(@Param("id")Integer id);

    int updateByPrimaryKeySelective(DeliverLocation record);

    int updateByPrimaryKey(DeliverLocation record);


}