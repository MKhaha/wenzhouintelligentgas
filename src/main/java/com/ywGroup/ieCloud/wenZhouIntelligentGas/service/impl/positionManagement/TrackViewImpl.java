package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.positionManagement;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.DeliverCarLocationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.DeliverCarMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.DeliverInformationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.DeliverLocationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCar;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCarLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.DeliverCarVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.DeliverInformationVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.positionManagement.ITrackViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lanmeiniu on 2017/8/29.
 */
@Service("iTrackViewService")

public class TrackViewImpl implements ITrackViewService {
    @Autowired
    private DeliverLocationMapper deliverLocationMapper;
    @Autowired
    private DeliverCarLocationMapper deliverCarLocationMapper;

    @Autowired
    private DeliverCarMapper deliverCarMapper;

    @Autowired
    private DeliverInformationMapper deliverInformationMapper;


    @Override
    public ServerResponse<List<DeliverCarVO>> searchTrackLatestById (Integer id) {
        //获取车辆详细信息；获取数据库中id的deliver_location_id
        List<DeliverCar> deliverCars = deliverCarMapper.selectAllById(id);
        if (deliverCars.isEmpty())
            return ServerResponse.createByErrorMessage("获取失败");
        List<DeliverCarVO> deliverCarVOs = new ArrayList<>();
        for (DeliverCar dc : deliverCars){
            DeliverCarVO dcv = new DeliverCarVO();
            dcv.setId(dc.getId());
            dcv.setLocationId(dc.getLocationId());
            dcv.setDeliverCarCode(dc.getDeliverCarCode());
            dcv.setCarLicensePlate(dc.getCarLicensePlate());
            dcv.setCompany(dc.getCompany());
            dcv.setStation(dc.getStation());
            dcv.setResponsible(dc.getResponsible());
            dcv.setPhoneResponsible(dc.getPhoneResponsible());
            DeliverCarLocation dcl = deliverCarLocationMapper.selectByPrimaryKey(dc.getLocationId());
            dcv.setTaskId(dcl.getTaskId());
            dcv.setTimestamp(dcl.getTimestamp());
            dcv.setLatitude(dcl.getLatitude());
            dcv.setLongitude(dcl.getLongitude());
            deliverCarVOs.add(dcv);
        }
        return ServerResponse.createBySuccess("获取成功",deliverCarVOs);


    }

    @Override
    public ServerResponse<List<DeliverInformationVO>> searchPersonLatestById(Integer id){
        //获取人员详细信息；获取数据库中id的deliver_information
        List<DeliverInformation> deliverInformations = deliverInformationMapper.selectAllById(id);
        if (deliverInformations.isEmpty())
            return ServerResponse.createByErrorMessage("获取失败");
        List<DeliverInformationVO> deliverInformationVOS = new ArrayList<>();
        for (DeliverInformation di : deliverInformations){

            DeliverInformationVO div = new DeliverInformationVO();
            div.setId(di.getId());
            div.setLocationId(di.getLocationId());
            div.setName(di.getName());
            div.setCompany(di.getCompany());
            div.setStation(di.getStation());
            div.setPhone(di.getPhone());
            div.setAddress(di.getAddress());
            div.setPhotoAddress(di.getPhotoAddress());
            DeliverLocation dl = deliverLocationMapper.selectByPrimaryKey(di.getLocationId());
           div.setTaskId(dl.getTaskId());
           div.setTimestamp(dl.getTimestamp());
           div.setLatitude(dl.getLatitude());
           div.setLongitude(dl.getLongitude());
           deliverInformationVOS.add(div);
        }
        return ServerResponse.createBySuccess("获取成功",deliverInformationVOS);
    }



}
