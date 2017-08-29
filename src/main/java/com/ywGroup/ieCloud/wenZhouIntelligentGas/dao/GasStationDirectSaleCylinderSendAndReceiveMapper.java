package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStationDirectSaleCylinderSendAndReceive;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.StoreCylinderSendAndReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GasStationDirectSaleCylinderSendAndReceiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GasStationDirectSaleCylinderSendAndReceive record);

    int insertSelective(GasStationDirectSaleCylinderSendAndReceive record);

    GasStationDirectSaleCylinderSendAndReceive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GasStationDirectSaleCylinderSendAndReceive record);

    int updateByPrimaryKey(GasStationDirectSaleCylinderSendAndReceive record);

    List<GasStationDirectSaleCylinderSendAndReceive> queryGasStationDirectSaleCylinderSendAndReceive(@Param("cylinderBarcode") String cylinderBarcode, @Param("manufacturingUnit") String manufacturingUnit, @Param("beginDate") String beginDate, @Param("endDate") String endDate);
}