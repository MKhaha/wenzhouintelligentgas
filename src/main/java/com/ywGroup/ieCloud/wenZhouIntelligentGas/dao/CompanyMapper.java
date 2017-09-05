package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> queryCompany(@Param("companyName") String companyName, @Param("createUser") String createUser);

    List<Map<String,String>> numberOfCompanyRegions();
}