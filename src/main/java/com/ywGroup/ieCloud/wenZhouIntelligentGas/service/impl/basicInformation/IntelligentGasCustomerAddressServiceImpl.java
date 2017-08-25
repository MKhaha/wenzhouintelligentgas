package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.IntelligentGasCustomerAddressMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.IntelligentGasCustomerAddress;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IIntelligentGasCustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/21.
 */
@Service("iIntelligentGasCustomerAddressService")
public class IntelligentGasCustomerAddressServiceImpl implements IIntelligentGasCustomerAddressService{

    @Autowired
    private IntelligentGasCustomerAddressMapper intelligentGasCustomerAddressMapper;

    @Override
    public ServerResponse<String> updateIntelligentGasCustomerAddress(IntelligentGasCustomerAddress intelligentGasCustomerAddress) {
        int resultCount = intelligentGasCustomerAddressMapper.updateByPrimaryKey(intelligentGasCustomerAddress);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("客户收货地址信息更新成功");
        }
        return ServerResponse.createByErrorMessage("客户收货地址信息更新失败");
    }

    @Override
    public ServerResponse<IntelligentGasCustomerAddress> checkIntelligentGasCustomerAddress(Integer id) {
        IntelligentGasCustomerAddress intelligentGasCustomerAddress = intelligentGasCustomerAddressMapper.selectByPrimaryKey(id);
        if(null != intelligentGasCustomerAddress) {
            return ServerResponse.createBySuccess("获取客户收货地址信息成功",intelligentGasCustomerAddress);
        }
        return ServerResponse.createByErrorMessage("获取客户收货地址信息失败");
    }

    @Override
    public ServerResponse<String> insertIntelligentGasCustomerAddress(IntelligentGasCustomerAddress intelligentGasCustomerAddress) {
        int resultCount = intelligentGasCustomerAddressMapper.insert(intelligentGasCustomerAddress);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入新的客户收货地址信息成功");
        }
        return ServerResponse.createByErrorMessage("插入新的客户收货地址信息失败");
    }

    @Override
    public ServerResponse<String> deleteIntelligentGasCustomerAddress(Integer id) {
        int resultCount = intelligentGasCustomerAddressMapper.deleteByPrimaryKey(id);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除客户收货地址信息成功");
        }
        return ServerResponse.createByErrorMessage("删除客户收货地址信息失败");
    }
}
