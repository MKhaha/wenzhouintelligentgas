package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.reportManagement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.AlarmEventRecordMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.AlarmEventRecord;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.reportManagement.IAlarmEventRecordService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guotao on 2017/8/30.
 * com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.reportManagement
 * wenzhouintelligentgas
 */
@Service("iAlarmEventRecordService")
public class AlarmEventRecordServiceImpl implements IAlarmEventRecordService {

    @Autowired
    private AlarmEventRecordMapper alarmEventRecordMapper;

    @Override
    public ServerResponse<PageInfo> getAlarmEventRecord(AlarmEventRecord alarmEventRecord, int pageNumber, int pageSize) {
        try {
            PageHelper.startPage(pageNumber, pageSize);
            List<AlarmEventRecord> alarmEventRecordList = alarmEventRecordMapper.selectMatchCondition(alarmEventRecord);
            if(CollectionUtils.isEmpty(alarmEventRecordList)) {
                return ServerResponse.createByErrorMessage("未找到符合条件的信息");
            }
            PageInfo pageResult = new PageInfo(alarmEventRecordList);
            pageResult.setList(alarmEventRecordList);
            return ServerResponse.createBySuccess(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("数据库操作出现问题");
        }
    }

    @Override
    public ServerResponse<Map<String, Map<Integer, List<Integer>>>> getCountAlarmEventRecordGroupByAdministrativeRegions() {

        Map<String, Map<Integer, List<Integer>>> mapCountAlarmEventRecord = new HashMap<>();

        Map<Integer, List<Integer>> mapCountAlarmEventRecordWenZhou = new HashMap<>();
        Map<Integer, List<Integer>> mapCountAlarmEventRecordItem = null;
        List<Integer> idList = null;

        List<AlarmEventRecord> alarmEventRecordList = alarmEventRecordMapper.selectAll();
        for (AlarmEventRecord item : alarmEventRecordList) {

            mapCountAlarmEventRecordItem = mapCountAlarmEventRecord.get(item.getAdministrativeRegions());
            if (mapCountAlarmEventRecordItem == null) {
                mapCountAlarmEventRecordItem = new HashMap<>();
                mapCountAlarmEventRecord.put(item.getAdministrativeRegions(), mapCountAlarmEventRecordItem);
            }

            idList = mapCountAlarmEventRecordItem.get(item.getGrade());
            if (idList == null) {
                idList = new ArrayList<>();
                mapCountAlarmEventRecordItem.put(item.getGrade(), idList);
            }

            idList.add(item.getId());


            idList = mapCountAlarmEventRecordWenZhou.get(item.getGrade());
            if (idList == null) {
                idList = new ArrayList<>();
                mapCountAlarmEventRecordWenZhou.put(item.getGrade(), idList);
            }
            idList.add(item.getId());
        }

        mapCountAlarmEventRecord.put("温州市", mapCountAlarmEventRecordWenZhou);

//        System.out.println(mapCountAlarmEventRecord);
//        System.out.println(mapCountAlarmEventRecordWenZhou);

        return ServerResponse.createBySuccess("获取统计信息成功", mapCountAlarmEventRecord);
    }
}
