package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderInformation;

/**
 * Created by lenovo on 2017/8/18.
 */
public interface IGasCylinderInformationService {
    ServerResponse<String> updateGasCylinderInformation(GasCylinderInformation gasCylinderInformation);

    ServerResponse<GasCylinderInformation> checkGasCylinderInformation(Integer id);

    ServerResponse<String> insertGasCylinderInformation(GasCylinderInformation gasCylinderInformation);

    ServerResponse<String> deleteGasCylinderInformation(Integer id);
}
