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

    @RequestMapping(value = "showGasCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<GasCylinderLocation> showGasCylinderLocation(Integer id){
        return iGasCylinderLocationService.showGasCylinderLocation(id);
    }

    @RequestMapping(value = "setGasCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> setGasCylinderLocation(GasCylinderLocation gasCylinderLocation){
        return iGasCylinderLocationService.setGasCylinderLocation(gasCylinderLocation);
    }

    @RequestMapping(value = "updateGasCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateGasCylinderLocation(GasCylinderLocation gasCylinderLocation){
        return iGasCylinderLocationService.updateGasCylinderLocation(gasCylinderLocation);
    }

}
