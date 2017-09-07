package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Administrator;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Role;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-8-21.
 */
@Controller
@RequestMapping("/systemSettings/roles/")
public class RoleController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private IRoleService iRoleService;


    /**
     * 给用户，设置角色
     * @param userid
     * @param roleNumber
     * @return
     */
    @RequestMapping(value = "set.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setRole(int userid,String roleNumber){
        return iRoleService.setRole(userid, roleNumber);
    }

    //======================================================================================================================

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addRole(Role role){
        //AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        role.setIsDelete(0);
        return iRoleService.addRole(role);
    }

    /**
     * 删除角色
     * @param roleNumber
     * @return
     */
    @RequestMapping(value = "delete.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delRole(String roleNumber){
        return iRoleService.delRole(roleNumber);
    }

    /**
     * 获取角色列表
     * @return
     */
    @RequestMapping(value = "get.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoles(@RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,
                                   @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                   @RequestParam(value = "roleName",defaultValue = "")String roleName,
                                   @RequestParam(value = "remark",defaultValue = "")String remark,
                                   @RequestParam(value = "departmentNumber",defaultValue = "")String departmentnumber){
        return iRoleService.getRoles(httpSession,pageNumber,pageSize,roleName,remark,departmentnumber);
    }


    /**
     * 编辑角色
     * @param role
     * @return
     */
    @RequestMapping(value ="update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateRole(Role role){
        return iRoleService.updateRole(role);
    }

    /**
     * 导出角色列表
     * @param roleName
     * @param remark
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "ToExcel.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcel(@RequestParam(value = "roleName",defaultValue = "")String roleName,
                                  @RequestParam(value = "remark",defaultValue = "")String remark){
        return iRoleService.toExcel(httpSession,remark,roleName);
    }
}
