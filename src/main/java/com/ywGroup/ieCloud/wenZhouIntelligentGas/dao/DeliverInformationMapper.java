package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverInformation;

import java.util.List;

public interface DeliverInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverInformation record);

    int insertSelective(DeliverInformation record);

    List<DeliverInformation> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliverInformation record);

    int updateByPrimaryKey(DeliverInformation record);
}