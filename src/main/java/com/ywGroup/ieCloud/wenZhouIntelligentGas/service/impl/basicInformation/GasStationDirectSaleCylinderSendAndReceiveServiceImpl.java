package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasStationDirectSaleCylinderSendAndReceiveMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.FillingRecord;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStationDirectSaleCylinderSendAndReceive;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasStationDirectSaleCylinderSendAndReceiveService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iGasStationDirectSaleCylinderSendAndReceiveService")
public class GasStationDirectSaleCylinderSendAndReceiveServiceImpl implements IGasStationDirectSaleCylinderSendAndReceiveService{

    @Autowired
    private GasStationDirectSaleCylinderSendAndReceiveMapper gasStationDirectSaleCylinderSendAndReceiveMapper;

    @Override
    public ServerResponse queryGasStationDirectSaleCylinderSendAndReceive(int pageNumber, int pageSize, String cylinderBarcode, String manufacturingUnit, String beginDate, String endDate) {
        PageHelper.startPage(pageNumber, pageSize);
        List<GasStationDirectSaleCylinderSendAndReceive> gasStationDirectSaleCylinderSendAndReceiveList = gasStationDirectSaleCylinderSendAndReceiveMapper.queryGasStationDirectSaleCylinderSendAndReceive(cylinderBarcode,manufacturingUnit,beginDate,endDate);
        if(CollectionUtils.isEmpty(gasStationDirectSaleCylinderSendAndReceiveList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(gasStationDirectSaleCylinderSendAndReceiveList);
        pageResult.setList(gasStationDirectSaleCylinderSendAndReceiveList);
        return ServerResponse.createBySuccess("获取成功", pageResult);
    }
}
