package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomerAddress;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IIntelligentGasCustomerAddressService;
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
public class IntelligentGasCustomerAddressController {

    @Autowired
    private IIntelligentGasCustomerAddressService iIntelligentGasCustomerAddressService;

    @RequestMapping(value = "updateIntelligentGasCustomerAddress.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateIntelligentGasCustomerAddress(IntelligentGasCustomerAddress intelligentGasCustomerAddress){
        return iIntelligentGasCustomerAddressService.updateIntelligentGasCustomerAddress(intelligentGasCustomerAddress);
    }

    @RequestMapping(value = "checkIntelligentGasCustomerAddress.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<IntelligentGasCustomerAddress> checkIntelligentGasCustomerAddress(Integer id){
        return iIntelligentGasCustomerAddressService.checkIntelligentGasCustomerAddress(id);
    }

    @RequestMapping(value = "insertIntelligentGasCustomerAddress.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertIntelligentGasCustomerAddress(IntelligentGasCustomerAddress intelligentGasCustomerAddress){
        return iIntelligentGasCustomerAddressService.insertIntelligentGasCustomerAddress(intelligentGasCustomerAddress);
    }

    @RequestMapping(value = "deleteIntelligentGasCustomerAddress.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteIntelligentGasCustomerAddress(Integer id){
        return iIntelligentGasCustomerAddressService.deleteIntelligentGasCustomerAddress(id);
    }


}
