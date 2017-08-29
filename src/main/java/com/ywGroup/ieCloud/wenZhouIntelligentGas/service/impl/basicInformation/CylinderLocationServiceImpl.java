package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.CylinderLocationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICylinderLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/28.
 */
@Service("iCylinderLocationService")
public class CylinderLocationServiceImpl implements ICylinderLocationService {

    @Autowired
    private CylinderLocationMapper cylinderLocationMapper;
    @Override
    public ServerResponse<CylinderLocation> checkByCylinderSerialNumber(String cylinderSerialNumber) {
       CylinderLocation cylinderLocation = cylinderLocationMapper.checkByCylinderSerialNumber(cylinderSerialNumber);
       if(null == cylinderLocation) {
           return ServerResponse.createByErrorMessage("获取失败");
       }
        return ServerResponse.createBySuccess("获取成功",cylinderLocation);
    }
}
