package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.CylinderLocationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICylinderLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by lenovo on 2017/8/28.
 */
@Service("iCylinderLocationService")
public class CylinderLocationServiceImpl implements ICylinderLocationService {

    @Autowired
    private CylinderLocationMapper cylinderLocationMapper;
    @Override
    public ServerResponse<CylinderLocation> queryCylinderLocationByCylinderSerialNumber(String cylinderSerialNumber) {
       CylinderLocation cylinderLocation = cylinderLocationMapper.queryCylinderLocationByCylinderSerialNumber(cylinderSerialNumber);
       if(null == cylinderLocation) {
           return ServerResponse.createByErrorMessage("获取失败");
       }
        return ServerResponse.createBySuccess("获取成功",cylinderLocation);
    }

    @Override
    public ServerResponse queryAllCylinderLocation(int pageNumber,int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<CylinderLocation> cylinderLocationList = cylinderLocationMapper.queryAllCylinderLocation();
        if(CollectionUtils.isEmpty(cylinderLocationList)) {
            ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(cylinderLocationList);
        pageResult.setList(cylinderLocationList);
        return  ServerResponse.createByError("获取成功",pageResult);
    }
}
