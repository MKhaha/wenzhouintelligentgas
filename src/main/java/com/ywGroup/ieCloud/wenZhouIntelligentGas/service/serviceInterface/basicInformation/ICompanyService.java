package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/29.
 */
public interface ICompanyService {
    ServerResponse queryCompany(int pageNumber, int pageSize, String companyName, String createUser);

    ServerResponse insertCompany(Company company);

    ServerResponse toExcelCompany(HttpSession session, String companyName, String createUser);
}
