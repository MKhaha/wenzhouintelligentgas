package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomerAddress;

/**
 * Created by lenovo on 2017/8/21.
 */
public interface IIntelligentGasCustomerAddressService {
    ServerResponse<String> updateIntelligentGasCustomerAddress(IntelligentGasCustomerAddress intelligentGasCustomerAddress);

    ServerResponse<IntelligentGasCustomerAddress> checkIntelligentGasCustomerAddress(Integer id);

    ServerResponse<String> insertIntelligentGasCustomerAddress(IntelligentGasCustomerAddress intelligentGasCustomerAddress);

    ServerResponse<String> deleteIntelligentGasCustomerAddress(Integer id);
}
