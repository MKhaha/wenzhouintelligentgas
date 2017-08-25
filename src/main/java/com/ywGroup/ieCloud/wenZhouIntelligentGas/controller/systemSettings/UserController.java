package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.UserVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-8-18.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    private IUserService iUserService;

    //用户登陆
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(String phoneNumber, String password){
        UserVO userVO = (UserVO)httpSession.getAttribute(Const.CURRENT_USER);
        if (userVO!=null) {
            if(userVO.getMobile().equals(phoneNumber))
                return ServerResponse.createBySuccessMessage("您已经登陆");
            else
                return ServerResponse.createByErrorMessage("您已用其他账号登陆，请先退出");
        }
        return iUserService.login(phoneNumber,password,httpSession);
    }

    //注销
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse logout(){
        httpSession.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("注销成功");
    }



}
