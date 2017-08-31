package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/26.
 */
public interface IGasStationTransportCylinderSendAndReceiveService {
    ServerResponse queryGasStationTransportCylinderSendAndReceive(int pageNumber, int pageSize, String cylinderBarcode, String manufacturingUnit, String beginDate, String endDate);

    ServerResponse toExcelGasStationTransportCylinderSendAndReceive(HttpSession session, String cylinderBarcode, String manufacturingUnit, String beginDate, String endDate);
}
