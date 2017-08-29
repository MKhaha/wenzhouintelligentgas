package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.CustomerInformationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CustomerInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.ICustomerInformationService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
