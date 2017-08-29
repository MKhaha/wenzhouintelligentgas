package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICylinderLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by lenovo on 2017/8/28.
 */
@Controller
@RequestMapping("/basicInformation/")
public class CylinderLocationController {

    @Autowired
    private ICylinderLocationService iCylinderLocationService;

    @RequestMapping(value = "checkByCylinderSerialNumber.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<CylinderLocation> checkByCylinderSerialNumber(@RequestParam(value = "cylinderSerialNumber",defaultValue = "")String cylinderSerialNumber){
        return iCylinderLocationService.checkByCylinderSerialNumber(cylinderSerialNumber);
    }
}
