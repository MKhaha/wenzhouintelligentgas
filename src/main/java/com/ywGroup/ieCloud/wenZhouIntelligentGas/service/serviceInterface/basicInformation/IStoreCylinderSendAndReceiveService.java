package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;


import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

/**
 * Created by lenovo on 2017/8/26.
 */
public interface IStoreCylinderSendAndReceiveService {
    ServerResponse queryStoreCylinderSendAndReceive(int pageNumber,int pageSize,String cylinderBarcode,String beginDate,String endDate);
}
