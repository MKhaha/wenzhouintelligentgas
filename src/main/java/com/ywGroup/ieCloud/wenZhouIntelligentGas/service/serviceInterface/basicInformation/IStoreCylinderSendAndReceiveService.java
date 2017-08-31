package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;


import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/26.
 */
public interface IStoreCylinderSendAndReceiveService {
    ServerResponse queryStoreCylinderSendAndReceive(int pageNumber, int pageSize, String cylinderBarcode, String beginDate, String endDate);

    ServerResponse toExcelStoreCylinderSendAndReceive(HttpSession session, String cylinderBarcode, String beginDate, String endDate);
}
