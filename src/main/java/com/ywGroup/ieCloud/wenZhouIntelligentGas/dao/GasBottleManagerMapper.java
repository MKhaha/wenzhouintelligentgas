package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasBottleManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GasBottleManagerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GasBottleManager record);

    int insertSelective(GasBottleManager record);

    GasBottleManager selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GasBottleManager record);

    int updateByPrimaryKey(GasBottleManager record);

    List<GasBottleManager> queryGasBottleManager(@Param("cylinderBarcode") String cylinderBarcode, @Param("manufacturingUnit") String manufacturingUnit, @Param("beginLandingDate") String beginLandingDate, @Param("endLandingDate") String endLandingDate, @Param("beginLastInspectionDate") String beginLastInspectionDate, @Param("endLastInspectionDate") String endLastInspectionDate, @Param("beginNextInspectionDate") String beginNextInspectionDate, @Param("endNextInspectionDate") String endNextInspectionDate);

    List<Map<String, String>> numberOfGasBottleManagerRegions();

    List<Map<String, String>> due();

    List<Map<String, String>> overdue();
}