package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasCylinderSpecificationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderSpecification;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasCylinderSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/18.
 */
@Service("iGasCylinderSpecificationService")
public class GasCylinderSpecificationServiceImpl implements IGasCylinderSpecificationService {

    @Autowired
    private GasCylinderSpecificationMapper gasCylinderSpecificationMapper;

    @Override
    public ServerResponse<String> updateGasCylinderSpecification(GasCylinderSpecification gasCylinderSpecification) {
        int resultCount = gasCylinderSpecificationMapper.updateByPrimaryKey(gasCylinderSpecification);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse<GasCylinderSpecification> checkGasCylinderSpecification(Integer id) {
        GasCylinderSpecification gasCylinderSpecification = gasCylinderSpecificationMapper.selectByPrimaryKey(id);
        if(null != gasCylinderSpecification) {
            return ServerResponse.createBySuccess("获取成功",gasCylinderSpecification);
        }
        return ServerResponse.createByErrorMessage("当前信息不存在");
    }

    @Override
    public ServerResponse<String> insertGasCylinderSpecification(GasCylinderSpecification gasCylinderSpecification) {
        int resultCount = gasCylinderSpecificationMapper.insert(gasCylinderSpecification);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入成功");
        }
        return ServerResponse.createByErrorMessage("插入失败");
    }

    @Override
    public ServerResponse<String> deleteGasCylinderSpecification(Integer id) {
        int resultCount = gasCylinderSpecificationMapper.deleteByPrimaryKey(id);
        if(resultCount > 0) {
           return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
}
