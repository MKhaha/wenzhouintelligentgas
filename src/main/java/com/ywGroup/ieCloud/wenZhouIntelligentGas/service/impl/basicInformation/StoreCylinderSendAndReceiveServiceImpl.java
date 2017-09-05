package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.StoreCylinderSendAndReceiveMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.StoreCylinderSendAndReceive;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IStoreCylinderSendAndReceiveService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.ExportExcel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iStoreCylinderSendAndReceiveService")
public class StoreCylinderSendAndReceiveServiceImpl implements IStoreCylinderSendAndReceiveService {

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

    @Override
    public ServerResponse toExcelStoreCylinderSendAndReceive(HttpSession session, String cylinderBarcode, String beginDate, String endDate) {
        List<StoreCylinderSendAndReceive> storeCylinderSendAndReceiveList = storeCylinderSendAndReceiveMapper.queryStoreCylinderSendAndReceive(cylinderBarcode,beginDate,endDate);
        if(CollectionUtils.isEmpty(storeCylinderSendAndReceiveList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        String path = ExportExcel.toExcel(session,"sheet1","store_cylinder_send_and_receive","store_cylinder_send_and_receive",storeCylinderSendAndReceiveList);
        if(org.apache.commons.lang3.StringUtils.isBlank(path)) {
            return ServerResponse.createByErrorMessage("导出失败");
        }
        return ServerResponse.createBySuccess("导出成功",path);
    }
}
