package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.FillingRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FillingRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FillingRecord record);

    int insertSelective(FillingRecord record);

    FillingRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FillingRecord record);

    int updateByPrimaryKey(FillingRecord record);

    List<FillingRecord> queryFillingRecord(@Param("cylinderBarcode") String cylinderBarcode, @Param("fillingWorker") String fillingWorker);
}