package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Administrator;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017-8-18.
 */
public interface IUserService {
    ServerResponse<AdministatorVO> login(String phoneNumber, String password, HttpSession session);
    ServerResponse<String> sendVerificationCode(String phoneNumber, String verificationCode);
    ServerResponse<String> register(Administrator administrator, String verificationCode, HttpSession ession);
    ServerResponse<String> sendResetPasswordVerificationCode(String phoneNumber, String verificationCode);
    ServerResponse<String> resetPassword(String phoneNumber, String password, String verificationCode, HttpSession httpSession);
    ServerResponse<AdministatorVO> setInformation(Administrator administrator, HttpSession session);
    ServerResponse<PageHelperUtil> getAdministrators(HttpSession httpSession, int pageNumber, int pageSize,
                                                     String userName, String department, String roleNumber);
//ServerResponse<PageInfo> getAdministrators(HttpSession httpSession, int pageNumber, int pageSize,
//                                                 String userName, String department, String roleNumber);
    ServerResponse<String> addAdministrator(Administrator administrator, HttpSession httpSession);
    ServerResponse<String> delete(Integer userid);
    ServerResponse<String> toExcel(HttpSession session,String userName,String department,String roleNumber);
}
