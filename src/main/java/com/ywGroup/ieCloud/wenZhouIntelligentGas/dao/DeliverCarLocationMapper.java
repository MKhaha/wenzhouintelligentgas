package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCarLocation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DeliverCarLocationMapper {
    int insert(DeliverCarLocation record);

    int insertSelective(DeliverCarLocation record);

    List<DeliverCarLocation> selectByCarId (Integer CarId);

    //将传入的time1 和time2 作为参数传入mybatis里
    List<DeliverCarLocation> selectByCarTimeSlot(@Param("time1") Date time1, @Param("time2") Date time2);
}