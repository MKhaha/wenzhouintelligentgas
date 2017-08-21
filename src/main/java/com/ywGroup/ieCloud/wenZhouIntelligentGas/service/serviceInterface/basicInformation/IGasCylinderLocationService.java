package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderLocation;

/**
 * Created by lenovo on 2017/8/18.
 */
public interface IGasCylinderLocationService {
    ServerResponse<GasCylinderLocation> showGasCylinderLocation(Integer id);

    ServerResponse<String> setGasCylinderLocation(GasCylinderLocation gasCylinderLocation);

    ServerResponse<String> updateGasCylinderLocation(GasCylinderLocation gasCylinderLocation);
}
