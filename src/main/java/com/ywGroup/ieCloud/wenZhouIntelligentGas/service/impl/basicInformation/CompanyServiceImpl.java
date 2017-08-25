package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.CompanyMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/21.
 */
@Service("iCompanyService")
public class CompanyServiceImpl implements ICompanyService{

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ServerResponse<String> updateCompany(Company company) {
        int resultCount = companyMapper.updateByPrimaryKey(company);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("公司信息更新成功");
        }
        return ServerResponse.createByErrorMessage("公司信息更新失败");
    }

    @Override
    public ServerResponse<Company> checkCompany(Integer id) {
        Company company = companyMapper.selectByPrimaryKey(id);
        if(null != company) {
            return ServerResponse.createBySuccess("获取公司信息成功",company);
        }
        return ServerResponse.createByErrorMessage("获取公司信息失败");
    }

    @Override
    public ServerResponse<String> insertCompany(Company company) {
        int resultCount = companyMapper.insert(company);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入新的公司信息成功");
        }
        return ServerResponse.createByErrorMessage("插入新的公司信息失败");
    }

    @Override
    public ServerResponse<String> deleteCompany(Integer id) {
        int resultCount = companyMapper.deleteByPrimaryKey(id);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除公司信息成功");
        }
        return ServerResponse.createByErrorMessage("删除公司信息失败");
    }
}
