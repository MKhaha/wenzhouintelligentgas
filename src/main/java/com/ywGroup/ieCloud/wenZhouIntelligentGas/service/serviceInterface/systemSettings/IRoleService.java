package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Role;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017-8-21.
 */
public interface IRoleService {
    ServerResponse<String> addRole(Role role);
    ServerResponse<String> delRole(String roleNumber);
    ServerResponse<PageHelperUtil> getRoles(HttpSession session, int pageNumber, int pageSize,String roleName,String remark);
    ServerResponse<String> setRole(Integer userid,String roleNumber);
    ServerResponse<String> updateRole(Role role);
}
