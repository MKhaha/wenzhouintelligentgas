package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasStationService;
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
public class GasStationController {

    @Autowired
    private IGasStationService iGasStationService;

    @RequestMapping(value = "selectGasStationAll.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse selectGasStationAll(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                              @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iGasStationService.selectGasStationAll(pageNumber,pageSize);
    }

    @RequestMapping(value = "selectGasStationByCode.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse selectGasStationByCode(@RequestParam(value = "code",defaultValue = "") String code){
        return iGasStationService.selectGasStationByCode(code);
    }

    @RequestMapping(value = "deleteGasStationByCode.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteGasStationByCode(@RequestParam(value = "code",defaultValue = "") String code){
        return iGasStationService.deleteGasStationByCode(code);
    }

    @RequestMapping(value = "insertGasStation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse insertGasStation(GasStation gasStation){
        return iGasStationService.insertGasStation(gasStation);
    }

    @RequestMapping(value = "updateGasStation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateGasStation(GasStation gasStation){
        return iGasStationService.updateGasStation(gasStation);
    }
}
