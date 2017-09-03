package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCarLocation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DeliverCarLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverCarLocation record);

    int insertSelective(DeliverCarLocation record);

    DeliverCarLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliverCarLocation record);

    int updateByPrimaryKey(DeliverCarLocation record);

    List<DeliverCarLocation> select(@Param("deliverCarId") Integer deliverCarId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}