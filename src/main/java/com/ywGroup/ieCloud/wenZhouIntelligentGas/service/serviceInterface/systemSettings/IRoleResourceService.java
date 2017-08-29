package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

/**
 * Created by Administrator on 2017-8-21.
 */
public interface IRoleResourceService {
    ServerResponse setResources(String[] resources,String roleNumber);
}
