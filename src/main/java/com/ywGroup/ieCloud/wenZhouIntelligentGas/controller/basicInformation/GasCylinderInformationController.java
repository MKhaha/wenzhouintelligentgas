package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasCylinderInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2017/8/18.
 */
@Controller
@RequestMapping("/basicInformation/")
public class GasCylinderInformationController {

    @Autowired
    private IGasCylinderInformationService iGasCylinderInformationService;

    @RequestMapping(value = "updateGasCylinderInformation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateGasCylinderInformation(GasCylinderInformation gasCylinderInformation){
        return iGasCylinderInformationService.updateGasCylinderInformation(gasCylinderInformation);
    }

    @RequestMapping(value = "checkGasCylinderInformation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<GasCylinderInformation> checkGasCylinderInformation(Integer id){
        return iGasCylinderInformationService.checkGasCylinderInformation(id);
    }

    @RequestMapping(value = "insertGasCylinderInformation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertGasCylinderInformation(GasCylinderInformation gasCylinderInformation){
        return iGasCylinderInformationService.insertGasCylinderInformation(gasCylinderInformation);
    }

    @RequestMapping(value = "deleteGasCylinderInformation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteGasCylinderInformation(Integer id){
        return iGasCylinderInformationService.deleteGasCylinderInformation(id);
    }
}
