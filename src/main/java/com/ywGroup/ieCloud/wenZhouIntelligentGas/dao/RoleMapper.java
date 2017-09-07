package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int checkByNumber(String roleNumber);

    String checkName(String roleNumber);

    int deleteByRoleNumber(String roleNumber);

    List<Role> getRoles(@Param("departmentnumber") String departmentnumber, @Param("roleName") String roleName, @Param("remark") String remark);

    String selectByRoleNumber(String roleNumber);

    int selectBylastID();
}