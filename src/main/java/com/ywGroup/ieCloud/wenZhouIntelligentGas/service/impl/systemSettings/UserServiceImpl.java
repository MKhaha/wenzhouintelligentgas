package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.AdministratorMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.ResourceMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleResourceRelationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Administrator;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Resource;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Role;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.UserVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IUserService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017-8-18.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private AdministratorMapper administratorMapper;
    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;

    @Override
    public ServerResponse<UserVO> login(String phoneNumber, String password, HttpSession session) {
        Administrator administrator = administratorMapper.selectByPhoneAndPwd(phoneNumber, password);//MD5Util.MD5EncodeUtf8(password));
        UserVO userVO = new UserVO();
        if(administrator!=null){
            int count = administratorMapper.updateLoginCount(administrator.getId());
            if(count>0) {
                List<String> resources = roleResourceRelationMapper.selectByRoleNumber(administrator.getRoleNumber());
                userVO.setId(administrator.getId());
                userVO.setUserName(administrator.getUserName());
                userVO.setUserCode(administrator.getUserCode());
                userVO.setRealName(administrator.getRealName());
                userVO.setEmail(administrator.getEmail());
                userVO.setMobile(administrator.getMobile());
                userVO.setPhone(administrator.getPhone());
                userVO.setPicture(administrator.getPicture());
                userVO.setStatus(administrator.getStatus());
                userVO.setDepartment(administrator.getDepartment());
                userVO.setParentCode(administrator.getParentCode());
                userVO.setRoleNumber(administrator.getRoleNumber());
                userVO.setRemark(administrator.getRemark());
                userVO.setRoles(resources.toArray(new String[resources.size()]));
                session.setAttribute(Const.CURRENT_USER, userVO);
                return ServerResponse.createBySuccess("登陆成功", userVO);
            }
        }
        return ServerResponse.createByErrorMessage("登陆失败");
    }
}
