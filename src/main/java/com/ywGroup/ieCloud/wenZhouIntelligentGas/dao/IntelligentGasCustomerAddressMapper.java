package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomerAddress;

public interface IntelligentGasCustomerAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntelligentGasCustomerAddress record);

    int insertSelective(IntelligentGasCustomerAddress record);

    IntelligentGasCustomerAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IntelligentGasCustomerAddress record);

    int updateByPrimaryKey(IntelligentGasCustomerAddress record);
}