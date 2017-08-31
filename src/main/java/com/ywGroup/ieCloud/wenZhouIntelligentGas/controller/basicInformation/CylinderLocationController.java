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

import javax.servlet.http.HttpSession;


/**
 * Created by lenovo on 2017/8/28.
 */
@Controller
@RequestMapping("/basicInformation/")
public class CylinderLocationController {

    @Autowired
    private ICylinderLocationService iCylinderLocationService;

    @RequestMapping(value = "queryCylinderLocationByCylinderSerialNumber.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<CylinderLocation> queryCylinderLocationByCylinderSerialNumber(@RequestParam(value = "cylinderSerialNumber",defaultValue = "")String cylinderSerialNumber){
        return iCylinderLocationService.queryCylinderLocationByCylinderSerialNumber(cylinderSerialNumber);
    }

    @RequestMapping(value = "queryAllCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryAllCylinderLocation(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                   @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iCylinderLocationService.queryAllCylinderLocation(pageNumber,pageSize);
    }

    @RequestMapping(value = "toExcelAllCylinderLocation.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcelAllCylinderLocation(HttpSession session){
        return iCylinderLocationService.toExcelAllCylinderLocation(session);
    }
}
