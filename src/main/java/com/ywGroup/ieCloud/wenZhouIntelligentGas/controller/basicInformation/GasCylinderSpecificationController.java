package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderSpecification;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasCylinderSpecificationService;
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
public class GasCylinderSpecificationController {

   @Autowired
   private IGasCylinderSpecificationService iGasCylinderSpecificationService;

    @RequestMapping(value = "checkGasCylinderSpecification.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<GasCylinderSpecification> checkGasCylinderSpecification(Integer id){
        return iGasCylinderSpecificationService.checkGasCylinderSpecification(id);
    }

    @RequestMapping(value = "deleteGasCylinderSpecification.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteGasCylinderSpecification(Integer id){
        return iGasCylinderSpecificationService.deleteGasCylinderSpecification(id);
    }

    @RequestMapping(value = "updateGasCylinderSpecification.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateGasCylinderSpecification(GasCylinderSpecification gasCylinderSpecification){
        return iGasCylinderSpecificationService.updateGasCylinderSpecification(gasCylinderSpecification);
    }

    @RequestMapping(value = "insertGasCylinderSpecification.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertGasCylinderSpecification(GasCylinderSpecification gasCylinderSpecification){
        return iGasCylinderSpecificationService.insertGasCylinderSpecification(gasCylinderSpecification);
    }
}
