package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICustomerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by lenovo on 2017/8/26.
 */
@Controller
@RequestMapping("/basicInformation/")
public class CustomerInformationController {

    @Autowired
    private ICustomerInformationService iCustomerInformationService;
    @RequestMapping(value = "queryCustomerInformation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryCustomerInformation(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                @RequestParam(value = "gas",defaultValue = "") String gas,
                                                @RequestParam(value = "onSite",defaultValue = "") String onSite,
                                                @RequestParam(value = "clientName",defaultValue = "") String clientName){
        return iCustomerInformationService.queryCustomerInformation(pageNumber,pageSize,gas,onSite,clientName);
    }
}
