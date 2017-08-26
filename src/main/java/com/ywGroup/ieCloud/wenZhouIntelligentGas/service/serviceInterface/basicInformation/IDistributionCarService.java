package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DistributionCar;

/**
 * Created by lenovo on 2017/8/21.
 */
public interface IDistributionCarService {
    ServerResponse<String> updateDistributionCar(DistributionCar distributionCar);

    ServerResponse<DistributionCar> checkDistributionCar(Integer id);

    ServerResponse<String> insertDistributionCar(DistributionCar distributionCar);

    ServerResponse<String> deleteDistributionCar(Integer id);
}
