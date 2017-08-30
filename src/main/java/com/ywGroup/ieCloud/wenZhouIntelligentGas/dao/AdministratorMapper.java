package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectByPhoneAndPwd(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

    int updateLoginCount(Integer id);

    int checkPhone(String phoneNumber);

    int updateByRestCode(@Param("phoneNumber") String phoneNumber,@Param("mdPassword") String mdPassword);

    int setRole(@Param("userid") Integer userid,@Param("roleNumber") String roleNumber);

    List<Administrator> getAdministrators(@Param("company") String company,
                                          @Param("userName") String userName,
                                          @Param("department") String department,
                                          @Param("roleNumber") String roleNumber);

    int deleteById(Integer userid);

    int checkByRoleNumber(String roleNumber);

    int selectByDepartment(String department);

    String selectMobileByid(Integer id);

}