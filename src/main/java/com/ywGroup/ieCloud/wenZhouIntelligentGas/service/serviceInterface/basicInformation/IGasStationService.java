package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStation;

/**
 * Created by lenovo on 2017/9/4.
 */
public interface IGasStationService {
    ServerResponse updateGasStation(GasStation gasStation);

    ServerResponse selectGasStationAll(int pageNumber, int pageSize);

    ServerResponse deleteGasStationByCode(String code);

    ServerResponse insertGasStation(GasStation gasStation);

    ServerResponse selectGasStationByCode(String code);
}
