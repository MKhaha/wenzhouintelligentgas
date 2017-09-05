package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/26.
 */
public interface IFillingRecordService {
    ServerResponse queryFillingRecord(int pageNumber, int pageSize, String cylinderBarcode, String fillingWorker);

    ServerResponse toExcelFillingRecord(HttpSession session, String cylinderBarcode, String fillingWorker);
}
