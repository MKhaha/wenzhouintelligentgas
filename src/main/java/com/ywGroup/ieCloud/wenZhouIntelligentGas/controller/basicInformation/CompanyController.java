package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo on 2017/8/21.
 */
@Controller
@RequestMapping("/basicInformation/")
public class CompanyController {

    @Autowired
    private ICompanyService iCompanyService;

    @RequestMapping(value = "updateCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateCompany(Company company){
        return iCompanyService.updateCompany(company);
    }

    @RequestMapping(value = "checkCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Company> checkCompany(Integer id){
        return iCompanyService.checkCompany(id);
    }

    @RequestMapping(value = "insertCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> insertCompany(Company company){
        return iCompanyService.insertCompany(company);
    }

    @RequestMapping(value = "deleteCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteCompany(Integer id){
        return iCompanyService.deleteCompany(id);
    }
}
