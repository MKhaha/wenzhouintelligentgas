package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStationTransportCylinderSendAndReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GasStationTransportCylinderSendAndReceiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GasStationTransportCylinderSendAndReceive record);

    int insertSelective(GasStationTransportCylinderSendAndReceive record);

    GasStationTransportCylinderSendAndReceive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GasStationTransportCylinderSendAndReceive record);

    int updateByPrimaryKey(GasStationTransportCylinderSendAndReceive record);

    List<GasStationTransportCylinderSendAndReceive> queryGasStationTransportCylinderSendAndReceive(@Param("cylinderBarcode") String cylinderBarcode, @Param("manufacturingUnit") String manufacturingUnit, @Param("beginDate") String beginDate, @Param("endDate") String endDate);
}