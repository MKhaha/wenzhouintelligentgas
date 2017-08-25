package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.DistributionCarMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DistributionCar;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IDistributionCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/21.
 */
@Service("iDistributionCarService")
public class DistributionCarServiceImpl implements IDistributionCarService{

    @Autowired
    private DistributionCarMapper distributionCarMapper;

    @Override
    public ServerResponse<String> updateDistributionCar(DistributionCar distributionCar) {
        int resultCount = distributionCarMapper.updateByPrimaryKey(distributionCar);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("信息分配车辆更新成功");
        }
        return ServerResponse.createByErrorMessage("信息分配车辆更新失败");
    }

    @Override
    public ServerResponse<DistributionCar> checkDistributionCar(Integer id) {
        DistributionCar distributionCar = distributionCarMapper.selectByPrimaryKey(id);
        if(null != distributionCar) {
            return ServerResponse.createBySuccess("获取车辆信息成功",distributionCar);
        }
        return ServerResponse.createByErrorMessage("获取车辆信息失败");
    }

    @Override
    public ServerResponse<String> insertDistributionCar(DistributionCar distributionCar) {
        int resultCount = distributionCarMapper.insert(distributionCar);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入新的车辆信息成功");
        }
        return ServerResponse.createByErrorMessage("插入新的车辆信息失败");

    }

    @Override
    public ServerResponse<String> deleteDistributionCar(Integer id) {
        int resultCount = distributionCarMapper.deleteByPrimaryKey(id);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除车辆信息成功");
        }
        return ServerResponse.createByErrorMessage("删除车辆信息失败");
    }
}
