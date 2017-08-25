package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;

/**
 * Created by lenovo on 2017/8/21.
 */
public interface ICompanyService {
    ServerResponse<String> updateCompany(Company company);

    ServerResponse<Company> checkCompany(Integer id);

    ServerResponse<String> insertCompany(Company company);

    ServerResponse<String> deleteCompany(Integer id);
}
