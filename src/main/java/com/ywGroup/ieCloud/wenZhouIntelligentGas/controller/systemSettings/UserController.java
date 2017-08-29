package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Administrator;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IUserService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.DigitalVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-8-18.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    private IUserService iUserService;

    /**
     * 用户登陆
     * @param mobile
     * @param password
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(String mobile, String password){
        AdministatorVO administatorVO = (AdministatorVO)httpSession.getAttribute(Const.CURRENT_USER);
        if (administatorVO !=null) {
            if(administatorVO.getMobile().equals(mobile))
                return ServerResponse.createBySuccessMessage("您已经登陆");
            else
                return ServerResponse.createByErrorMessage("您已用其他账号登陆，请先退出");
        }
        return iUserService.login(mobile,password,httpSession);
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse logout(){
        httpSession.removeAttribute(Const.CURRENT_USER);
        httpSession.removeAttribute(Const.Resource_URLS);
        return ServerResponse.createBySuccessMessage("注销成功");
    }

    /**
     * 注册时发送验证码
     * @param mobile
     * @return
     */
    @RequestMapping(value = "sendVerificationCode.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sendVerificationCode(String mobile) {
        String verificationCode = DigitalVerificationCode.getVerificationCode();
        ServerResponse<String> response = iUserService.sendVerificationCode(mobile, verificationCode);
        if (response.isSuccess()) {
            httpSession.setAttribute(mobile, verificationCode);
        }
        return response;
    }

    /**
     * 注册
     * @param administrator
     * @param verificationCode
     * @return
     */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse register(Administrator administrator, String verificationCode){
        return iUserService.register(administrator, verificationCode, httpSession);
    }

    /**
     * 忘记密码时，发送验证码
     * @param mobile
     * @return
     */
    @RequestMapping(value = "sendResetVerificationCode.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sendResetPasswordVerificationCode(String mobile) {
        String verificationCode = DigitalVerificationCode.getVerificationCode();
        ServerResponse<String> response = iUserService.sendResetPasswordVerificationCode(mobile, verificationCode);
        if (response.isSuccess()) {
            httpSession.setAttribute(mobile, verificationCode);
        }
        return response;
    }

    /**
     * 重置密码
     * @param mobile
     * @param password
     * @param verificationCode
     * @return
     */
    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse resetPassword(String mobile,String password,String verificationCode){
        return iUserService.resetPassword(mobile,password,verificationCode,httpSession);
    }

    /**
     * 完善用户信息
     * @param administrator
     * @return
     */
    @RequestMapping(value = "setInformation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setInformation(Administrator administrator){
        return iUserService.setInformation(administrator,httpSession);
    }

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(value = "getAdministrators.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getAdministrators(@RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,
                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iUserService.getAdministrators(httpSession,pageNumber,pageSize);
    }

    /**
     * 删除用户，ie_delete=1
     * @param userid
     * @return
     */
    @RequestMapping(value = "delete.do",method =RequestMethod.POST)
    @ResponseBody
    public ServerResponse delete(int userid){
        return iUserService.delete(userid);
    }
}
