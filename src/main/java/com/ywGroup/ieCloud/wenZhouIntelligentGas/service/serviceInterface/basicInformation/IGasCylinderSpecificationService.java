package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasCylinderSpecification;

/**
 * Created by lenovo on 2017/8/18.
 */
public interface IGasCylinderSpecificationService {

    ServerResponse<String> updateGasCylinderSpecification(GasCylinderSpecification gasCylinderSpecification);

    ServerResponse<GasCylinderSpecification> checkGasCylinderSpecification(Integer id);

    ServerResponse<String> insertGasCylinderSpecification(GasCylinderSpecification gasCylinderSpecification);

    ServerResponse<String> deleteGasCylinderSpecification(Integer id);
}
