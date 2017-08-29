package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasBottleManager;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface GasBottleManagerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GasBottleManager record);

    int insertSelective(GasBottleManager record);

    GasBottleManager selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GasBottleManager record);

    int updateByPrimaryKey(GasBottleManager record);

    List<GasBottleManager> queryGasBottleManager(@Param("cylinderBarcode") String cylinderBarcode, @Param("manufacturingUnit") String manufacturingUnit, @Param("beginLandingDate") String beginLandingDate,@Param("endLandingDate") String endLandingDate,@Param("beginLastInspectionDate") String beginLastInspectionDate,@Param("endLastInspectionDate") String endLastInspectionDate,@Param("beginNextInspectionDate") String beginNextInspectionDate,@Param("endNextInspectionDate") String endNextInspectionDate);
}