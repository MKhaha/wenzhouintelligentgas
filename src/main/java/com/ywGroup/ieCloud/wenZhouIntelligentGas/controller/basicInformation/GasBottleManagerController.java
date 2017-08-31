package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasBottleManager;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasBottleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;


/**
 * Created by lenovo on 2017/8/26.
 */
@Controller
@RequestMapping("/basicInformation/")
public class GasBottleManagerController {

    @Autowired
    private IGasBottleManageService iGasBottleManageService;

    @RequestMapping(value = "queryGasBottleManager.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryGasBottleManager(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                                @RequestParam(value = "manufacturingUnit",defaultValue = "") String manufacturingUnit,
                                                @RequestParam(value = "beginLandingDate",defaultValue = "") String beginLandingDate,
                                                @RequestParam(value = "endLandingDate",defaultValue = "") String endLandingDate,
                                                @RequestParam(value = "beginLastInspectionDate",defaultValue = "") String beginLastInspectionDate,
                                                @RequestParam(value = "endLastInspectionDate",defaultValue = "") String endLastInspectionDate,
                                                @RequestParam(value = "beginNextInspectionDate",defaultValue = "") String beginNextInspectionDate,
                                                @RequestParam(value = "endNextInspectionDate",defaultValue = "") String endNextInspectionDate){
        System.out.println(System.currentTimeMillis());
        return iGasBottleManageService.queryGasBottleManager(pageNumber,pageSize,cylinderBarcode,manufacturingUnit,beginLandingDate,endLandingDate,beginLastInspectionDate,endLastInspectionDate,beginNextInspectionDate,endNextInspectionDate);
    }


    @RequestMapping(value = "toExcelGasBottleManager.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcelGasBottleManager(HttpSession session,
                                                  @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                                  @RequestParam(value = "manufacturingUnit",defaultValue = "") String manufacturingUnit,
                                                  @RequestParam(value = "beginLandingDate",defaultValue = "") String beginLandingDate,
                                                  @RequestParam(value = "endLandingDate",defaultValue = "") String endLandingDate,
                                                  @RequestParam(value = "beginLastInspectionDate",defaultValue = "") String beginLastInspectionDate,
                                                  @RequestParam(value = "endLastInspectionDate",defaultValue = "") String endLastInspectionDate,
                                                  @RequestParam(value = "beginNextInspectionDate",defaultValue = "") String beginNextInspectionDate,
                                                  @RequestParam(value = "endNextInspectionDate",defaultValue = "") String endNextInspectionDate){
        System.out.println(System.currentTimeMillis());
        return iGasBottleManageService.toExcelGasBottleManager(session,cylinderBarcode,manufacturingUnit,beginLandingDate,endLandingDate,beginLastInspectionDate,endLastInspectionDate,beginNextInspectionDate,endNextInspectionDate);
    }

    @RequestMapping(value = "insertGasBottleManager.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse insertGasBottleManager(GasBottleManager gasBottleManager,HttpSession session){
        if(null != session.getAttribute(Const.NSJUDGE)) {
            int status = (Integer) session.getAttribute(Const.NSJUDGE);
            if(status == 0) {
                gasBottleManager.setSn(UUID.randomUUID().toString().replaceAll("-",""));
            } else {
                gasBottleManager.setSn(String.valueOf(new Date().getTime()));
            }
        }
        return iGasBottleManageService.insertGasBottleManager(gasBottleManager);
    }

    @RequestMapping(value = "useNsByUUID.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse useNsByUUID(HttpSession session){
        session.setAttribute(Const.NSJUDGE,Const.NsJudge.NSJUDGE_UUID);
        return ServerResponse.createBySuccessMessage("设置成功");
    }

    @RequestMapping(value = "useNsByTimeDate.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse useNsByTimeDate(HttpSession session){
        session.setAttribute(Const.NSJUDGE,Const.NsJudge.NSJUDGE_TIMEDATE);
        return ServerResponse.createBySuccessMessage("设置成功");
    }

    @RequestMapping(value = "useNsByNoUse.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse useNsByNoUse(HttpSession session){
        session.removeAttribute(Const.NSJUDGE);
        return ServerResponse.createBySuccessMessage("设置成功");
    }
}
