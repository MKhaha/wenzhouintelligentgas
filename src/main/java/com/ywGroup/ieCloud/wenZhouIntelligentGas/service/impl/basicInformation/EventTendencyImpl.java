package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.EventTendencyMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.EventTendency;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IEventTendencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/9/4.
 */
@Service("iEventTendency")
public class EventTendencyImpl implements IEventTendencyService{

    @Autowired
    private EventTendencyMapper eventTendencyMapper;
    @Override
    public ServerResponse selectAll() {
        List<EventTendency> eventTendencyList = eventTendencyMapper.selectAll();
        if(org.apache.commons.collections.CollectionUtils.isEmpty(eventTendencyList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        return ServerResponse.createBySuccess("获取成功",eventTendencyList);
    }

    @Override
    public ServerResponse queryEventTendencyByAdministrativeRegions(String administrativeRegions) {
        List<EventTendency> eventTendencyList = eventTendencyMapper.queryEventTendencyByAdministrativeRegions(administrativeRegions);
        if(org.apache.commons.collections.CollectionUtils.isEmpty(eventTendencyList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        return ServerResponse.createBySuccess("获取成功",eventTendencyList);
    }

}
