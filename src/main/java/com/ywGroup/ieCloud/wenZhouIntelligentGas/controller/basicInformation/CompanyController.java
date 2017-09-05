package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Company;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/8/29.
 */
@Controller
@RequestMapping("/basicInformation/")
public class CompanyController {

    @Autowired
    private ICompanyService iCompanyService;

    @RequestMapping(value = "queryCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryCompany(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                       @RequestParam(value = "companyName",defaultValue = "") String companyName,
                                       @RequestParam(value = "createUser",defaultValue = "") String createUser){
        return iCompanyService.queryCompany(pageNumber,pageSize,companyName,createUser);
    }

    @RequestMapping(value = "insertCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse queryCompany(Company company){
        return iCompanyService.insertCompany(company);
    }

    @RequestMapping(value = "toExcelCompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcelCompany(HttpSession session,
                                         @RequestParam(value = "companyName",defaultValue = "") String companyName,
                                         @RequestParam(value = "createUser",defaultValue = "") String createUser){
        return iCompanyService.toExcelCompany(session,companyName,createUser);
    }

    @RequestMapping(value = "numberOfCompanyRegions.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse numberOfCompanyRegions(){
        return iCompanyService.numberOfCompanyRegions();
    }
}
