package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IStoreCylinderSendAndReceiveService;
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
public class StoreCylinderSendAndReceiveController {

    @Autowired
    private IStoreCylinderSendAndReceiveService iStoreCylinderSendAndReceiveService;

    @RequestMapping(value = "queryStoreCylinderSendAndReceive.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryStoreCylinderSendAndReceive(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                           @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                           @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                                           @RequestParam(value = "beginDate",defaultValue = "") String beginDate,
                                                           @RequestParam(value = "endDate",defaultValue = "") String endDate){
        return iStoreCylinderSendAndReceiveService.queryStoreCylinderSendAndReceive(pageNumber,pageSize,cylinderBarcode,beginDate,endDate);
    }

    @RequestMapping(value = "toExcelStoreCylinderSendAndReceive.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcelStoreCylinderSendAndReceive(HttpSession session,
                                                             @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                                             @RequestParam(value = "beginDate",defaultValue = "") String beginDate,
                                                             @RequestParam(value = "endDate",defaultValue = "") String endDate){
        return iStoreCylinderSendAndReceiveService.toExcelStoreCylinderSendAndReceive(session,cylinderBarcode,beginDate,endDate);
    }
}
