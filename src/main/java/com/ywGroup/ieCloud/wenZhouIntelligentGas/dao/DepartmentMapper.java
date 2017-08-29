package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectDepartments(@Param("departmentName") String departmentName);

    int selectByParentNumbet(String departmentNumber);

    int deleteByDepartmentNumber(String departmentNumber);

    String selectByDepartmentNumber(String departmentNumber);

    int selectID();

    int checkByNumber(String departmentNumber);

    String selectParentName(String parentName);
}