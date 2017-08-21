package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomer;

/**
 * Created by lenovo on 2017/8/21.
 */
public interface IIntelligentGasCustomerService {
    ServerResponse<String> updateIntelligentGasCustomer(IntelligentGasCustomer intelligentGasCustomer);

    ServerResponse<IntelligentGasCustomer> checkIntelligentGasCustomer(Integer id);

    ServerResponse<String> insertIntelligentGasCustomer(IntelligentGasCustomer intelligentGasCustomer);

    ServerResponse<String> deleteIntelligentGasCustomer(Integer id);

}
