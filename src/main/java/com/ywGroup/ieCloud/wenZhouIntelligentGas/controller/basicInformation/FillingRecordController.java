package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.FillingRecord;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IFillingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
@Controller
@RequestMapping("/basicInformation/")
public class FillingRecordController {

    @Autowired
    private IFillingRecordService iFillingRecordService;

    @RequestMapping(value = "queryFillingRecord.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryFillingRecord(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                                @RequestParam(value = "fillingWorker",defaultValue = "") String fillingWorker){
        return iFillingRecordService.queryFillingRecord(pageNumber,pageSize,cylinderBarcode,fillingWorker);
    }

    @RequestMapping(value = "toExcelFillingRecord.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcelFillingRecord(HttpSession session,
                                               @RequestParam(value = "cylinderBarcode",defaultValue = "") String cylinderBarcode,
                                               @RequestParam(value = "fillingWorker",defaultValue = "") String fillingWorker){
        return iFillingRecordService.toExcelFillingRecord(session,cylinderBarcode,fillingWorker);
    }
}
