package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderLocation;

/**
 * Created by lenovo on 2017/8/18.
 */
public interface IGasCylinderLocationService {
    ServerResponse<GasCylinderLocation> checkGasCylinderLocation(Integer id);

    ServerResponse<String> insertGasCylinderLocation(GasCylinderLocation gasCylinderLocation);

    ServerResponse<String> updateGasCylinderLocation(GasCylinderLocation gasCylinderLocation);

    ServerResponse<String> deleteGasCylinderLocation(Integer id);
}
