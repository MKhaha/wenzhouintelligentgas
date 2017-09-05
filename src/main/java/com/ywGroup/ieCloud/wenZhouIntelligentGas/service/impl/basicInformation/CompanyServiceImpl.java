package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.CompanyMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICompanyService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.ExportExcel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/29.
 */
@Service("iCompanyService")
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public ServerResponse queryCompany(int pageNumber, int pageSize, String companyName, String createUser) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Company> companyList = companyMapper.queryCompany(companyName,createUser);
        if(CollectionUtils.isEmpty(companyList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(companyList);
        pageResult.setList(companyList);
        return ServerResponse.createBySuccess("获取成功", pageResult);
    }

    @Override
    public ServerResponse insertCompany(Company company) {
        System.out.println("company = " + company);
        int resultCount = companyMapper.insertSelective(company);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入数据成功");
        }
        return ServerResponse.createByErrorMessage("插入数据失败");
    }

    @Override
    public ServerResponse toExcelCompany(HttpSession session, String companyName, String createUser) {
        List<Company> companyList = companyMapper.queryCompany(companyName,createUser);
        if(CollectionUtils.isEmpty(companyList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        String path = ExportExcel.toExcel(session,"sheet1","company","company",companyList);
        if(org.apache.commons.lang3.StringUtils.isBlank(path)) {
            return ServerResponse.createByErrorMessage("导出失败");
        }
        return ServerResponse.createBySuccess("导出成功",path);
    }

    @Override
    public ServerResponse numberOfCompanyRegions() {
        List<Map<String,String>> map = companyMapper.numberOfCompanyRegions();
        if(CollectionUtils.isEmpty(map)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        return ServerResponse.createBySuccess("获取成功",map);
    }
}
