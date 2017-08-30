package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.reportManagement;

import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.AlarmEventRecord;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICustomerInformationService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.reportManagement.IAlarmEventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guotao on 2017/8/30.
 * com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.reportManagement
 * wenzhouintelligentgas
 */
@Controller
@RequestMapping("/reportManagement/")
public class AlarmEventRecordController {

    @Autowired
    private IAlarmEventRecordService iAlarmEventRecordService;

    @RequestMapping(value = "getAlarmEventRecord.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getAlarmEventRecord(AlarmEventRecord alarmEventRecord,
                                                        @RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                        @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iAlarmEventRecordService.getAlarmEventRecord(alarmEventRecord, pageNumber, pageSize);
    }

    @RequestMapping(value = "getCountAlarmEventRecordGroupByAdministrativeRegions.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Map<String, Map<Integer, List<Integer>>>> getCountAlarmEventRecordGroupByAdministrativeRegions(){
        return iAlarmEventRecordService.getCountAlarmEventRecordGroupByAdministrativeRegions();
    }

}
