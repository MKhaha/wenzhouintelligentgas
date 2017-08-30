package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.reportManagement;

import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.AlarmEventRecord;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by guotao on 2017/8/30.
 * com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.reportManagement
 * wenzhouintelligentgas
 */
public interface IAlarmEventRecordService {
    ServerResponse<PageInfo> getAlarmEventRecord(AlarmEventRecord alarmEventRecord, int pageNumber, int pageSize);

    ServerResponse<String> getCountAlarmEventRecordGroupByAdministrativeRegions();
}
