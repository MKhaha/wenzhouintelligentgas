package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.ResourceTreeVO;

/**
 * Created by Administrator on 2017-8-21.
 */
public interface IResourceService {
    ServerResponse<ResourceTreeVO> getResources(String resourceNumber);

}
