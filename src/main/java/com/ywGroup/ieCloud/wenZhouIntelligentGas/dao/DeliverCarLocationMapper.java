package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCarLocation;
import org.apache.ibatis.annotations.Param;



public interface DeliverCarLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverCarLocation record);

    int insertSelective(DeliverCarLocation record);

    DeliverCarLocation selectByPrimaryKey(@Param("id")Integer id);

    int updateByPrimaryKeySelective(DeliverCarLocation record);

    int updateByPrimaryKey(DeliverCarLocation record);

}