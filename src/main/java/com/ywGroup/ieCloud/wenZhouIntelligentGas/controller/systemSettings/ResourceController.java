package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IResourceService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IRoleResourceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

/**
 * Created by Administrator on 2017-8-21.
 */
@Controller
@RequestMapping("/systemSettings/resources/")
public class ResourceController {

    @Autowired
    private IResourceService iResourceService;
    @Autowired
    private IRoleResourceService iRoleResourceService;

    /**
     * 递归获取资源树
     * @return
     */
    @RequestMapping(value = "get.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getResources(@RequestParam(value = "resourceNumber",defaultValue = "0") String resourceNumber){
        return iResourceService.getResources(resourceNumber);
    }

    /**
     * 设置权限
     * @param resources
     * @param roleNumber
     * @return
     */
    @RequestMapping(value = "set.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setResources(@RequestParam("resources") String[] resources,@RequestParam("roleNumber") String roleNumber){
        return iRoleResourceService.setResources(resources,roleNumber);
    }

}
