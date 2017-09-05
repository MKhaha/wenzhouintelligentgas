package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasBottleManager;

import javax.servlet.http.HttpSession;


/**
 * Created by lenovo on 2017/8/26.
 */
public interface IGasBottleManageService {
    ServerResponse queryGasBottleManager(int pageNumber, int pageSize, String cylinderBarcode, String manufacturingUnit, String beginLandingDate, String endLandingDate, String beginLastInspectionDate, String endLastInspectionDate, String beginNextInspectionDate, String endNextInspectionDate);

    ServerResponse toExcelGasBottleManager(HttpSession session, String cylinderBarcode, String manufacturingUnit, String beginLandingDate, String endLandingDate, String beginLastInspectionDate, String endLastInspectionDate, String beginNextInspectionDate, String endNextInspectionDate);

    ServerResponse insertGasBottleManager(GasBottleManager gasBottleManager);

    ServerResponse numberOfGasBottleManagerRegions();

    ServerResponse due();

    ServerResponse overdue();
}
