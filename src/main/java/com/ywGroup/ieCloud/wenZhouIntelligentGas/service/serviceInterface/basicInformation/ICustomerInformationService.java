package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/26.
 */
public interface ICustomerInformationService {
    ServerResponse queryCustomerInformation(int pageNumber, int pageSize, String gas, String onSite, String clientName);

    ServerResponse toExcelCustomerInformation(HttpSession session, String gas, String onSite, String clientName);
}
