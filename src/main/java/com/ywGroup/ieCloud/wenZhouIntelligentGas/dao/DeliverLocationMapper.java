package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverLocation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DeliverLocationMapper {
    int insert(DeliverLocation record);

    int insertSelective(DeliverLocation record);

    List<DeliverLocation> selectById (Integer id);

    //将time1 time2 作为参数传递到mybatis中
    List<DeliverLocation> selectByTimeSlot(@Param("time1") Date time1,@Param("time2") Date time2);
}