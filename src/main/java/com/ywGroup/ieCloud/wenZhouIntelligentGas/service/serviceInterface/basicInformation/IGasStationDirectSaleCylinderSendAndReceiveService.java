package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

/**
 * Created by lenovo on 2017/8/26.
 */

public interface IGasStationDirectSaleCylinderSendAndReceiveService {
    ServerResponse queryGasStationDirectSaleCylinderSendAndReceive(int pageNumber,int pageSize, String cylinderBarcode, String manufacturingUnit, String beginDate, String endDate);
}
