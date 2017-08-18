package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.UserVO;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-8-18.
 */
public interface IUserService {
    ServerResponse<UserVO> login(String phoneNumber, String password, HttpSession session);
}
