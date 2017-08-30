package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.AlarmEventRecord;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.reportManagement.IAlarmEventRecordService;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AlarmEventRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlarmEventRecord record);

    int insertSelective(AlarmEventRecord record);

    AlarmEventRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlarmEventRecord record);

    int updateByPrimaryKey(AlarmEventRecord record);

    // 查找符合条件的报警事件信息，不包括时间选择
    List<AlarmEventRecord> selectMatchCondition(AlarmEventRecord alarmEventRecord);

    // 查找所有报警事件信息
    List<AlarmEventRecord> selectAll();

    // 根据行政区域统计报警数量
    int getCountAlarmEventInWenZhou(String administrativeRegions);

}