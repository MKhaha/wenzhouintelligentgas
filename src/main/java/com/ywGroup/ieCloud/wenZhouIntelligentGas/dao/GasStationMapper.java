package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStation;

import java.util.List;

public interface GasStationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GasStation record);

    int insertSelective(GasStation record);

    GasStation selectByCode(String code);

    int updateByPrimaryKeySelective(GasStation gasStation);

    int updateByPrimaryKey(GasStation record);

    List<GasStation> selectAll();

    int deleteByCode(String code);
}