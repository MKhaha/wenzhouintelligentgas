package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.CustomerInformationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CustomerInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICustomerInformationService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.ExportExcel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iCustomerInformationService")
public class CustomerInformationServiceImpl implements ICustomerInformationService {

    @Autowired
    private CustomerInformationMapper customerInformationMapper;

    @Override
    public ServerResponse queryCustomerInformation(int pageNumber, int pageSize, String gas, String onSite, String clientName) {
        PageHelper.startPage(pageNumber, pageSize);
        List<CustomerInformation> customerInformationList = customerInformationMapper.queryCustomerInformation(gas,onSite,clientName);
        if(CollectionUtils.isEmpty(customerInformationList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(customerInformationList);
        pageResult.setList(customerInformationList);
        return ServerResponse.createBySuccess("获取成功", pageResult);
    }

    @Override
    public ServerResponse toExcelCustomerInformation(HttpSession session, String gas, String onSite, String clientName) {
        List<CustomerInformation> customerInformationList = customerInformationMapper.queryCustomerInformation(gas,onSite,clientName);
        if(CollectionUtils.isEmpty(customerInformationList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        String path = ExportExcel.toExcel(session,"sheet1","customer_information","customer_information",customerInformationList);
        if(org.apache.commons.lang3.StringUtils.isBlank(path)) {
            return ServerResponse.createByErrorMessage("导出失败");
        }
        return ServerResponse.createBySuccess("导出成功",path);
    }

    @Override
    public ServerResponse numberOfCustomerInformationRegions() {
        List<Map<String,String>> map = customerInformationMapper.numberOfCustomerInformationRegions();
        if(CollectionUtils.isEmpty(map)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        return ServerResponse.createBySuccess("获取成功",map);
    }
}
