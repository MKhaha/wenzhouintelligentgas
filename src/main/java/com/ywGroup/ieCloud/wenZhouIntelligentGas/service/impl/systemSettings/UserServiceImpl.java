package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.AliyunSms;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.*;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Administrator;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.Administrators;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IUserService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Administrator on 2017-8-18.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private AliyunSms aliyunSmsService;
    @Autowired
    private AdministratorMapper administratorMapper;
    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public ServerResponse<AdministatorVO> login(String phoneNumber, String password, HttpSession session) {
        Administrator administrator = administratorMapper.selectByPhoneAndPwd(phoneNumber,MD5Util.MD5EncodeUtf8(password));
        if(administrator!=null){
            int count = administratorMapper.updateLoginCount(administrator.getId());
            if(count>0) {
                return ServerResponse.createBySuccess("登陆成功", this.getAdministatorVO(administrator,session));
            }
        }
        return ServerResponse.createByErrorMessage("登陆失败");
    }

    @Override
    public ServerResponse<String> sendVerificationCode(String phoneNumber, String verificationCode) {
        int resultCount = administratorMapper.checkPhone(phoneNumber);
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("手机号已被注册");
        } else {
            return this.sendcode(phoneNumber, verificationCode);
        }
    }

    @Override
    public ServerResponse<String> register(Administrator administrator, String verificationCode, HttpSession session) {
        String Code = (String)session.getAttribute(administrator.getMobile());
        session.removeAttribute(administrator.getMobile());
        if(org.apache.commons.lang3.StringUtils.isBlank(verificationCode)){
            return ServerResponse.createByErrorMessage("请输入验证码");
        }
        if(verificationCode.equals(Code)){
            int resultCount = administratorMapper.checkPhone(administrator.getMobile());
            if(resultCount>0){
                return ServerResponse.createByErrorMessage("手机号已被注册");
            }
            else {
                administrator.setLoginCount(0);
                administrator.setIsDelete(0);
                administrator.setStatus(0);
                administrator.setRoleNumber("r1");
                administrator.setPassword(MD5Util.MD5EncodeUtf8(administrator.getPassword()));
                int resultCount1 = administratorMapper.insert(administrator);
                if (resultCount1 > 0) {
                    return ServerResponse.createBySuccessMessage("注册成功");
                } else
                    return ServerResponse.createByErrorMessage("注册失败");
            }
        }
        else{
            return ServerResponse.createByErrorMessage("验证码错误");
        }
    }

    @Override
    public ServerResponse<String> sendResetPasswordVerificationCode(String phoneNumber, String verificationCode) {
        int resultCount = administratorMapper.checkPhone(phoneNumber);
        if (resultCount > 0) {
            return this.sendcode(phoneNumber, verificationCode);
        } else {
            return ServerResponse.createByErrorMessage("手机号未注册");
        }
    }

    @Override
    public ServerResponse<String> resetPassword(String phoneNumber, String password, String verificationCode, HttpSession httpSession) {
        String Code = (String)httpSession.getAttribute(phoneNumber);
        if(org.apache.commons.lang3.StringUtils.isBlank(verificationCode)){
            return ServerResponse.createByErrorMessage("请输入验证码");
        }
        if(verificationCode.equals(Code)){
            int resultCount = administratorMapper.checkPhone(phoneNumber);
            if(resultCount>0){
                String mdPassword = MD5Util.MD5EncodeUtf8(password);
                int resultCount1 = administratorMapper.updateByRestCode(phoneNumber,mdPassword);
                if (resultCount1 > 0) {
                    return ServerResponse.createBySuccessMessage("重置密码成功");
                } else
                    return ServerResponse.createByErrorMessage("重置密码失败");
            }
            else {
                return ServerResponse.createByErrorMessage("手机号未注册");
            }
        }
        else{
            return ServerResponse.createByErrorMessage("验证码错误");
        }
    }

    @Override
    public ServerResponse<AdministatorVO> setInformation(Administrator administrator,HttpSession session) {
        if (administrator!=null){
            int count = administratorMapper.updateByPrimaryKeySelective(administrator);
            if (count>0){
                return ServerResponse.createBySuccess("更新成功",this.getAdministatorVO(administrator,session));
            }
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createByErrorMessage("用户为空");
    }

    @Override
    public ServerResponse<PageHelperUtil> getAdministrators(HttpSession httpSession,int pageNumber,int pageSize,
                                                            String userName, String department, String roleNumber) {
        //AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);administatorVO.getCompany()
        PageHelper.startPage(pageNumber,pageSize);
        List<Administrator> administrators = administratorMapper.getAdministrators("1",userName,department,roleNumber);
        PageInfo pageInfo = new PageInfo(administrators);
        List<Administrators> administratorsList = new ArrayList<>();
        if(!administrators.isEmpty()){
            for (Administrator administrator:administrators){
                Administrators administrators1 = new Administrators();
                administrators1.setId(administrator.getId());
                administrators1.setUserName(administrator.getUserName());
                administrators1.setUserCode(administrator.getUserCode());
                administrators1.setRealName(administrator.getRealName());
                administrators1.setEmail(administrator.getEmail());
                administrators1.setMobile(administrator.getMobile());
                administrators1.setPhone(administrator.getPhone());
                administrators1.setDepartment(administrator.getDepartment());
                administrators1.setDepartmentName(departmentMapper.selectByDepartmentNumber(administrator.getDepartment()));
                administrators1.setRoleNumber(administrator.getRoleNumber());
                administrators1.setRoleName(roleMapper.selectByRoleNumber(administrator.getRoleNumber()));
                administrators1.setRemark(administrator.getRemark());
                administratorsList.add(administrators1);
            }
            pageInfo.setList(administratorsList);
            return ServerResponse.createBySuccess("获取成功", PageHelperUtil.toPageHeper(pageInfo));
        }
        return ServerResponse.createByErrorMessage("获取失败");
    }

    @Override
    public ServerResponse<String> addAdministrator(Administrator administrator, HttpSession httpSession) {
        int resultCount = administratorMapper.checkPhone(administrator.getMobile());
        if(resultCount>0){
            return ServerResponse.createByErrorMessage("手机号已被注册");
        }
        //AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        administrator.setCompany("1");//administatorVO.getCompany()
        administrator.setLoginCount(0);
        administrator.setIsDelete(0);
        administrator.setStatus(0);
        administrator.setPassword(MD5Util.MD5EncodeUtf8(administrator.getPassword()));
        int resultCount1 = administratorMapper.insert(administrator);
        if (resultCount1 > 0) {
            return ServerResponse.createBySuccessMessage("注册成功");
        } else
            return ServerResponse.createByErrorMessage("注册失败");
    }

    @Override
    public ServerResponse<String> delete(Integer userid) {
        int count = administratorMapper.deleteById(userid);
        if(count > 0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    public File mkdir(String path) throws InterruptedException {
        System.out.println(path);
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        return  fileDir;
    }

    @Override
    public ServerResponse<String> toExcel(HttpSession session,String userName, String department, String roleNumber){
        List<Administrator> administrators = administratorMapper.getAdministrators("1",userName,department,roleNumber);
        String path = ExportExcel.toExcel(session,"sheet1","用户表","administrator",administrators);
        if (org.apache.commons.lang3.StringUtils.isBlank(path))
            return ServerResponse.createByErrorMessage("导出失败");
        return ServerResponse.createBySuccess("导出成功",path);
    }


    public AdministatorVO getAdministatorVO(Administrator administrator,HttpSession session){
        AdministatorVO administatorVO = new AdministatorVO();
        List<String> resources = roleResourceRelationMapper.selectByRoleNumber(administrator.getRoleNumber());
        List<String> resourceURLs = resourceMapper.selectUrlByNumber(administrator.getRoleNumber());
        administatorVO.setId(administrator.getId());
        administatorVO.setUserName(administrator.getUserName());
        administatorVO.setUserCode(administrator.getUserCode());
        administatorVO.setRealName(administrator.getRealName());
        administatorVO.setEmail(administrator.getEmail());
        administatorVO.setMobile(administrator.getMobile());
        administatorVO.setPhone(administrator.getPhone());
        administatorVO.setPicture(administrator.getPicture());
        administatorVO.setStatus(administrator.getStatus());
        administatorVO.setCompany(administrator.getCompany());
        administatorVO.setDepartment(administrator.getDepartment());
        administatorVO.setDepartmentName(departmentMapper.selectByDepartmentNumber(administrator.getDepartment()));
        administatorVO.setParentCode(administrator.getParentCode());
        administatorVO.setRoleNumber(administrator.getRoleNumber());
        administatorVO.setRoleName(roleMapper.selectByRoleNumber(administrator.getRoleNumber()));
        administatorVO.setRemark(administrator.getRemark());
        administatorVO.setResources(resources.toArray(new String[resources.size()]));
        session.setAttribute(Const.CURRENT_USER,administatorVO);
      //  session.setAttribute(Const.Resource_URLS,resourceURLs);
        return administatorVO;
    }



    public  ServerResponse<String> sendcode(String phone, String verificationCode) {
        aliyunSmsService.setPhoneNumber(phone);
        aliyunSmsService.setVerificationcode(verificationCode);
        try {
            //发短信
            SendSmsResponse response = aliyunSmsService.sendSms();
            Thread.sleep(200);
            if (response.getCode() != null && response.getCode().equals("OK")) {
                return ServerResponse.createBySuccessMessage("验证码发送成功");
            } else {
                return ServerResponse.createByErrorMessage("验证码发送失败");
            }

        } catch (com.aliyuncs.exceptions.ClientException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("客户端故障");
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("其他故障");
        }
    }
}
