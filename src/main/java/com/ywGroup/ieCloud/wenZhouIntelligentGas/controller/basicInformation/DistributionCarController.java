package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DistributionCar;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IDistributionCarService;
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
public class DistributionCarController {

    @Autowired
    private IDistributionCarService iDistributionCarService;

    @RequestMapping(value = "updateDistributionCar.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateDistributionCar(DistributionCar distributionCar){
        return iDistributionCarService.updateDistributionCar(distributionCar);
    }

    @RequestMapping(value = "checkDistributionCar.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<DistributionCar> checkDistributionCar(Integer id){
        return iDistributionCarService.checkDistributionCar(id);
    }

    @RequestMapping(value = "insertDistributionCar.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertDistributionCar(DistributionCar distributionCar){
        return iDistributionCarService.insertDistributionCar(distributionCar);
    }

    @RequestMapping(value = "deleteDistributionCar.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteDistributionCar(Integer id){
        return iDistributionCarService.deleteDistributionCar(id);
    }
}
