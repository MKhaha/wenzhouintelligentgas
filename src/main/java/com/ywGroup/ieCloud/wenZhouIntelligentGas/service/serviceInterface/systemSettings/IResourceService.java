package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-8-21.
 */
public interface IResourceService {
    ServerResponse<PageHelperUtil> getResources(Integer pageNumber, Integer pageSize, String resourceName, String remark);
    ServerResponse setResources(String[] resources, String roleNumber);
    ServerResponse<String> toExcel(HttpSession httpSession,String resourceName,String remark);
}
