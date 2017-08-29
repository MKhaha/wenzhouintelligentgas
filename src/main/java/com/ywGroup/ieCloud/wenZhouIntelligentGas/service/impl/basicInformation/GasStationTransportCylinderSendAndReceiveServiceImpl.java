package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasStationTransportCylinderSendAndReceiveMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStationTransportCylinderSendAndReceive;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasStationTransportCylinderSendAndReceiveService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iGasStationTransportCylinderSendAndReceiveService")
public class GasStationTransportCylinderSendAndReceiveServiceImpl implements IGasStationTransportCylinderSendAndReceiveService{

    @Autowired
    private GasStationTransportCylinderSendAndReceiveMapper gasStationTransportCylinderSendAndReceiveMapper;

    @Override
    public ServerResponse queryGasStationTransportCylinderSendAndReceive(int pageNumber, int pageSize, String cylinderBarcode, String manufacturingUnit, String beginDate, String endDate) {
        PageHelper.startPage(pageNumber, pageSize);
        List<GasStationTransportCylinderSendAndReceive> gasStationTransportCylinderSendAndReceiveList = gasStationTransportCylinderSendAndReceiveMapper.queryGasStationTransportCylinderSendAndReceive(cylinderBarcode,manufacturingUnit,beginDate,endDate);
        if(CollectionUtils.isEmpty(gasStationTransportCylinderSendAndReceiveList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(gasStationTransportCylinderSendAndReceiveList);
        pageResult.setList(gasStationTransportCylinderSendAndReceiveList);
        return ServerResponse.createBySuccess("获取成功", pageResult);
    }
}
