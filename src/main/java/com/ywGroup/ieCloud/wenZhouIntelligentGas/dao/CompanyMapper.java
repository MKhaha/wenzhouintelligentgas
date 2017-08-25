package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);
}