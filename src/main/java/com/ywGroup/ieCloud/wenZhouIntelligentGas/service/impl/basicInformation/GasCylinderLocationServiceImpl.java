package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasCylinderLocationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasCylinderLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/8/18.
 */
@Service("iGasCylinderLocationService")
public class GasCylinderLocationServiceImpl implements IGasCylinderLocationService{

    @Autowired
    private GasCylinderLocationMapper gasCylinderLocationMapper;

    @Override
    public ServerResponse<GasCylinderLocation> showGasCylinderLocation(Integer id) {
        GasCylinderLocation gasCylinderLocation = gasCylinderLocationMapper.selectByPrimaryKey(id);
        if(null != gasCylinderLocation) {
            return ServerResponse.createBySuccess("地理位置获取成功",gasCylinderLocation);
        }
        return ServerResponse.createByErrorMessage("地理位置获取失败");
    }

    @Override
    public ServerResponse<String> setGasCylinderLocation(GasCylinderLocation gasCylinderLocation) {
        int resultCount = gasCylinderLocationMapper.insert(gasCylinderLocation);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("位置信息设置成功");
        }
        return ServerResponse.createByErrorMessage("位置信息设置失败");
    }

    @Override
    public ServerResponse<String> updateGasCylinderLocation(GasCylinderLocation gasCylinderLocation) {
        int resultCount = gasCylinderLocationMapper.updateByPrimaryKey(gasCylinderLocation);
        if(resultCount > 0) {
             return ServerResponse.createBySuccessMessage("更新地理位置成功");
        }
        return ServerResponse.createByErrorMessage("更新地理位置失败");
    }
}
