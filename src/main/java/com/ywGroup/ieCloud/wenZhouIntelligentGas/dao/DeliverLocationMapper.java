package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverLocation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DeliverLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverLocation record);

    int insertSelective(DeliverLocation record);

    DeliverLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliverLocation record);

    int updateByPrimaryKey(DeliverLocation record);

    List<DeliverLocation> select(@Param("deliverId") Integer deliverId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}