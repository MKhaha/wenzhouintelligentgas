package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomer;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IIntelligentGasCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2017/8/21.
 */
@Controller
@RequestMapping("/basicInformation/")
public class IntelligentGasCustomerController {

    @Autowired
    private IIntelligentGasCustomerService iIntelligentGasCustomerService;

    @RequestMapping(value = "updateIntelligentGasCustomer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateIntelligentGasCustomer(IntelligentGasCustomer intelligentGasCustomer){
        return iIntelligentGasCustomerService.updateIntelligentGasCustomer(intelligentGasCustomer);
    }

    @RequestMapping(value = "checkIntelligentGasCustomer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<IntelligentGasCustomer> checkIntelligentGasCustomer(Integer id){
        return iIntelligentGasCustomerService.checkIntelligentGasCustomer(id);
    }

    @RequestMapping(value = "insertIntelligentGasCustomer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertIntelligentGasCustomer(IntelligentGasCustomer intelligentGasCustomer){
        return iIntelligentGasCustomerService.insertIntelligentGasCustomer(intelligentGasCustomer);
    }

    @RequestMapping(value = "deleteIntelligentGasCustomer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteIntelligentGasCustomer(Integer id){
        return iIntelligentGasCustomerService.deleteIntelligentGasCustomer(id);
    }
}
