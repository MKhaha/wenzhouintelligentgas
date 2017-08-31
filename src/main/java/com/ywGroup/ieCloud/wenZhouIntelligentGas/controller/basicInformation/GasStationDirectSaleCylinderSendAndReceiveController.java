package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasStationDirectSaleCylinderSendAndReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/26.
 */
@Controller
@RequestMapping("/basicInformation/")
public class GasStationDirectSaleCylinderSendAndReceiveController {

    @Autowired
    private IGasStationDirectSaleCylinderSendAndReceiveService iGasStationDirectSaleCylinderSendAndReceiveService;

    @RequestMapping(value = "queryGasStationDirectSaleCylinderSendAndReceive.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryGasStationDirectSaleCylinderSendAndReceive(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                                          @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                                          @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                                                          @RequestParam(value = "manufacturingUnit",defaultValue = "") String manufacturingUnit,
                                                                          @RequestParam(value = "beginDate",defaultValue = "") String beginDate,
                                                                          @RequestParam(value = "endDate",defaultValue = "") String endDate){
        return iGasStationDirectSaleCylinderSendAndReceiveService.queryGasStationDirectSaleCylinderSendAndReceive(pageNumber,pageSize,cylinderBarcode,manufacturingUnit,beginDate,endDate);
    }

    @RequestMapping(value = "toExcelGasStationDirectSaleCylinderSendAndReceive.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcelGasStationDirectSaleCylinderSendAndReceive(HttpSession session,
                                                                            @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                                                            @RequestParam(value = "manufacturingUnit",defaultValue = "") String manufacturingUnit,
                                                                            @RequestParam(value = "beginDate",defaultValue = "") String beginDate,
                                                                            @RequestParam(value = "endDate",defaultValue = "") String endDate){
        return iGasStationDirectSaleCylinderSendAndReceiveService.toExcelGasStationDirectSaleCylinderSendAndReceive(session,cylinderBarcode,manufacturingUnit,beginDate,endDate);
    }
}
