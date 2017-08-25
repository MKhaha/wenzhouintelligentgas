package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.IntelligentGasCustomerMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomer;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IIntelligentGasCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/21.
 */
@Service("iIntelligentGasCustomerService")
public class IntelligentGasCustomerServiceImpl implements IIntelligentGasCustomerService{

    @Autowired
    private IntelligentGasCustomerMapper intelligentGasCustomerMapper;

    @Override
    public ServerResponse<String> updateIntelligentGasCustomer(IntelligentGasCustomer intelligentGasCustomer) {
        int resultCount = intelligentGasCustomerMapper.updateByPrimaryKey(intelligentGasCustomer);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("客户信息更新成功");
        }
        return ServerResponse.createByErrorMessage("客户信息更新失败");
    }

    @Override
    public ServerResponse<IntelligentGasCustomer> checkIntelligentGasCustomer(Integer id) {
        IntelligentGasCustomer intelligentGasCustomer = intelligentGasCustomerMapper.selectByPrimaryKey(id);
        if(null != intelligentGasCustomer) {
            return ServerResponse.createBySuccess("获取客户信息成功",intelligentGasCustomer);
        }
        return ServerResponse.createByErrorMessage("获取客户信息失败");
    }

    @Override
    public ServerResponse<String> insertIntelligentGasCustomer(IntelligentGasCustomer intelligentGasCustomer) {
        int resultCount = intelligentGasCustomerMapper.insert(intelligentGasCustomer);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入新的客户信息成功");
        }
        return ServerResponse.createByErrorMessage("插入新的客户信息失败");
    }

    @Override
    public ServerResponse<String> deleteIntelligentGasCustomer(Integer id) {
        int resultCount = intelligentGasCustomerMapper.deleteByPrimaryKey(id);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除客户信息成功");
        }
        return ServerResponse.createByErrorMessage("删除客户信息失败");
    }
}
