package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomer;

public interface IntelligentGasCustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntelligentGasCustomer record);

    int insertSelective(IntelligentGasCustomer record);

    IntelligentGasCustomer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IntelligentGasCustomer record);

    int updateByPrimaryKey(IntelligentGasCustomer record);
}