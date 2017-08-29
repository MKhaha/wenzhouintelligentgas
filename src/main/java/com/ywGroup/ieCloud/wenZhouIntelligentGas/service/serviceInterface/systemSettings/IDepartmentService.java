package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Department;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;

/**
 * Created by Administrator on 2017-8-28.
 */
public interface IDepartmentService {
    ServerResponse<PageHelperUtil> getDepartments(Integer pageNumber, Integer pageSize, String departmentName);
    ServerResponse<String> addDepartment(Department department);
    ServerResponse<String> delDepartment(String departmentNumber);
    ServerResponse<String> updateDepartment(Department department);
}
