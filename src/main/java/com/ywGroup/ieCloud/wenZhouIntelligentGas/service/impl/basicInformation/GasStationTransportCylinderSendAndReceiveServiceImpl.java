package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasStationTransportCylinderSendAndReceiveMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStationTransportCylinderSendAndReceive;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasStationTransportCylinderSendAndReceiveService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.ExportExcel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iGasStationTransportCylinderSendAndReceiveService")
public class GasStationTransportCylinderSendAndReceiveServiceImpl implements IGasStationTransportCylinderSendAndReceiveService {

    @Autowired
    private GasStationTransportCylinderSendAndReceiveMapper gasStationTransportCylinderSendAndReceiveMapper;

    @Override
    public ServerResponse queryGasStationTransportCylinderSendAndReceive(int pageNumber, int pageSize, String cylinderBarcode, String manufacturingUnit, String beginDate, String endDate) {
        PageHelper.startPage(pageNumber, pageSize);
        List<GasStationTransportCylinderSendAndReceive> gasStationTransportCylinderSendAndReceiveList = gasStationTransportCylinderSendAndReceiveMapper.queryGasStationTransportCylinderSendAndReceive(cylinderBarcode,manufacturingUnit,beginDate,endDate);
        if(CollectionUtils.isEmpty(gasStationTransportCylinderSendAndReceiveList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(gasStationTransportCylinderSendAndReceiveList);
        pageResult.setList(gasStationTransportCylinderSendAndReceiveList);
        return ServerResponse.createBySuccess("获取成功", pageResult);
    }

    @Override
    public ServerResponse toExcelGasStationTransportCylinderSendAndReceive(HttpSession session, String cylinderBarcode, String manufacturingUnit, String beginDate, String endDate) {
        List<GasStationTransportCylinderSendAndReceive> gasStationTransportCylinderSendAndReceiveList = gasStationTransportCylinderSendAndReceiveMapper.queryGasStationTransportCylinderSendAndReceive(cylinderBarcode,manufacturingUnit,beginDate,endDate);
        if(CollectionUtils.isEmpty(gasStationTransportCylinderSendAndReceiveList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        String path = ExportExcel.toExcel(session,"sheet1","gas_station_transport_cylinder_send_and_receive","gas_station_transport_cylinder_send_and_receive",gasStationTransportCylinderSendAndReceiveList);
        if(org.apache.commons.lang3.StringUtils.isBlank(path)) {
            return ServerResponse.createByErrorMessage("导出失败");
        }
        return ServerResponse.createBySuccess("导出成功",path);
    }
}
