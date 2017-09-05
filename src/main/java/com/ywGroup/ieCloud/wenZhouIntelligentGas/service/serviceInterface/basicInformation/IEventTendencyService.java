package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;


/**
 * Created by lenovo on 2017/9/4.
 */
public interface IEventTendencyService {
    ServerResponse selectAll();

    ServerResponse queryEventTendencyByAdministrativeRegions(String administrativeRegions);
}
