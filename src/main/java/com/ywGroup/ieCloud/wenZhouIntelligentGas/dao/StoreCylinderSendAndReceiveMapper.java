package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.StoreCylinderSendAndReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreCylinderSendAndReceiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StoreCylinderSendAndReceive record);

    int insertSelective(StoreCylinderSendAndReceive record);

    StoreCylinderSendAndReceive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StoreCylinderSendAndReceive record);

    int updateByPrimaryKey(StoreCylinderSendAndReceive record);

    List<StoreCylinderSendAndReceive> queryStoreCylinderSendAndReceive(@Param("cylinderBarcode") String cylinderBarcode,@Param("beginDate") String beginDate,@Param("endDate") String endDate);
}