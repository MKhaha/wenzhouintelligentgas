package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasCylinderInformationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasCylinderInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/18.
 */
@Service("iGasCylinderInformationService")
public class GasCylinderInformationServiceImpl implements IGasCylinderInformationService{

    @Autowired
    private GasCylinderInformationMapper gasCylinderInformationMapper;

    @Override
    public ServerResponse<GasCylinderInformation> updateGasCylinderInformation(GasCylinderInformation gasCylinderInformation) {
        int resultCount = gasCylinderInformationMapper.updateByPrimaryKey(gasCylinderInformation);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("信息更新成功");
        }
        return ServerResponse.createByErrorMessage("信息更新失败");
    }

    @Override
    public ServerResponse<GasCylinderInformation> checkGasCylinderInformation(Integer id) {
        GasCylinderInformation gasCylinderInformation = gasCylinderInformationMapper.selectByPrimaryKey(id);
        if(null != gasCylinderInformation) {
            return ServerResponse.createBySuccess("获取钢瓶信息成功",gasCylinderInformation);
        }
        return ServerResponse.createByErrorMessage("获取钢瓶信息失败");
    }

    @Override
    public ServerResponse<String> insertGasCylinderInformation(GasCylinderInformation gasCylinderInformation) {
        int resultCount = gasCylinderInformationMapper.insert(gasCylinderInformation);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入新的钢瓶信息成功");
        }
        return ServerResponse.createByErrorMessage("插入新的钢瓶信息失败");
    }

    @Override
    public ServerResponse<String> deleteGasCylinderInformation(Integer id) {
        int resultCount = gasCylinderInformationMapper.deleteByPrimaryKey(id);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除钢瓶信息成功");
        }
        return ServerResponse.createByErrorMessage("删除钢瓶信息失败");
    }
}
