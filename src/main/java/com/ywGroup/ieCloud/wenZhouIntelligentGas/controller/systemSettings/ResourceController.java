package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017-8-21.
 */
@Controller
@RequestMapping("/systemSettings/resources/")
public class ResourceController {

    @Autowired
    private IResourceService iResourceService;
//    /**
//     * 递归获取资源树
//     * @return
//     */
//    @RequestMapping(value = "get.do",method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse getResources(@RequestParam(value = "resourceNumber",defaultValue = "0") String resourceNumber){
//        return iResourceService.getResources(resourceNumber);
//    }

    /**
     //     * 获取资源列表
     //     * @return
     //     */
    @RequestMapping(value = "get.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getResources(@RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,
                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                       @RequestParam(value = "resourceName",defaultValue = "")String resourceName,
                                       @RequestParam(value = "remark",defaultValue = "")String remark){
        return iResourceService.getResources(pageNumber,pageSize,resourceName,remark);
    }

    /**
     * 设置权限
     * @param powerList
     * @param roleNumber
     * @return
     */
    @RequestMapping(value = "set.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setResources(@RequestParam("powerList") String[] powerList,@RequestParam("roleNumber") String roleNumber){
        return iResourceService.setResources(powerList,roleNumber);
    }

}
