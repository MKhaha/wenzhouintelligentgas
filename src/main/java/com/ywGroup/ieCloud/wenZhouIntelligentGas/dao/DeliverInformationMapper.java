package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliverInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliverInformation record);

    int insertSelective(DeliverInformation record);

    List<DeliverInformation> selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(DeliverInformation record);

    int updateByPrimaryKey(DeliverInformation record);

    List<DeliverInformation> selectAllById(@Param("id") Integer id);




}