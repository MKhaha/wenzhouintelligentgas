package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CustomerInformation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
public interface ICustomerInformationService {
    ServerResponse queryCustomerInformation(int pageNumber,int pageSize,String gas,String onSite,String clientName);
}
