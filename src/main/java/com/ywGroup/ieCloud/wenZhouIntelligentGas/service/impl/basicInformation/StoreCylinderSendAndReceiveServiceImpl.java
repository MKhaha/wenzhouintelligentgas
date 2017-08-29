package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.StoreCylinderSendAndReceiveMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.StoreCylinderSendAndReceive;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IStoreCylinderSendAndReceiveService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iStoreCylinderSendAndReceiveService")
public class StoreCylinderSendAndReceiveServiceImpl implements IStoreCylinderSendAndReceiveService{

    @Autowired
    private StoreCylinderSendAndReceiveMapper storeCylinderSendAndReceiveMapper;

    @Override
    public ServerResponse queryStoreCylinderSendAndReceive(int pageNumber, int pageSize, String cylinderBarcode, String beginDate, String endDate) {
        PageHelper.startPage(pageNumber, pageSize);
        List<StoreCylinderSendAndReceive> storeCylinderSendAndReceiveList = storeCylinderSendAndReceiveMapper.queryStoreCylinderSendAndReceive(cylinderBarcode,beginDate,endDate);
        if(CollectionUtils.isEmpty(storeCylinderSendAndReceiveList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(storeCylinderSendAndReceiveList);
        pageResult.setList(storeCylinderSendAndReceiveList);
        return ServerResponse.createBySuccess("获取成功", pageResult);
    }
}
