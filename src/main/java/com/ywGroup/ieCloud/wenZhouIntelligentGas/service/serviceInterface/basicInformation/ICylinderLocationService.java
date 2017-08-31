package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/28.
 */
public interface ICylinderLocationService {
    ServerResponse<CylinderLocation> queryCylinderLocationByCylinderSerialNumber(String cylinderSerialNumber);

    ServerResponse queryAllCylinderLocation(int pageNumber,int pageSize);

    ServerResponse toExcelAllCylinderLocation(HttpSession session);
}
