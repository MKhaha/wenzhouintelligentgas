package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasCylinderLocationService;
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
public class GasCylinderLocationController {

    @Autowired
    private IGasCylinderLocationService iGasCylinderLocationService;

    @RequestMapping(value = "checkGasCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<GasCylinderLocation> checkGasCylinderLocation(Integer id){
        return iGasCylinderLocationService.checkGasCylinderLocation(id);
    }

    @RequestMapping(value = "insertGasCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertGasCylinderLocation(GasCylinderLocation gasCylinderLocation){
        return iGasCylinderLocationService.insertGasCylinderLocation(gasCylinderLocation);
    }

    @RequestMapping(value = "updateGasCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateGasCylinderLocation(GasCylinderLocation gasCylinderLocation){
        return iGasCylinderLocationService.updateGasCylinderLocation(gasCylinderLocation);
    }

    @RequestMapping(value = "deleteGasCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteGasCylinderLocation(Integer id){
        return iGasCylinderLocationService.deleteGasCylinderLocation(id);
    }
}
