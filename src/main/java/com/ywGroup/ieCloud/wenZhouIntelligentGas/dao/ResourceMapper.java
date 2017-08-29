package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> selectByResourceNumber(@Param("resourceName") String resourceName,@Param("remark") String remark);

    List<Resource> selectByParentNumber(String parentNumber);

    List<String> selectUrlByNumber(String roleNumber);

    String selectParentName(String partentNumber);
}