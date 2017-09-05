package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CustomerInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerInformation record);

    int insertSelective(CustomerInformation record);

    CustomerInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerInformation record);

    int updateByPrimaryKey(CustomerInformation record);

    List<CustomerInformation> queryCustomerInformation(@Param("gas") String gas, @Param("onSite") String onSite, @Param("clientName") String clientName);

    List<Map<String, String>> numberOfCustomerInformationRegions();
}