package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IEventTendencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2017/9/4.
 */
@Controller
@RequestMapping("/basicInformation/")
public class EventTendencyController {

    @Autowired
    private IEventTendencyService iEventTendencyService;

    @RequestMapping(value = "selectAll.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse selectAll(){
        return iEventTendencyService.selectAll();
    }

    @RequestMapping(value = "queryEventTendencyByAdministrativeRegions.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryEventTendencyByAdministrativeRegions(@RequestParam(value = "administrativeRegions",defaultValue = "") String administrativeRegions){
        return iEventTendencyService.queryEventTendencyByAdministrativeRegions(administrativeRegions);
    }
}
