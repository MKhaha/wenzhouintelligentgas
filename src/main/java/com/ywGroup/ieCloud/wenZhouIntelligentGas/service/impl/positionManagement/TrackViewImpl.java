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
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.positionManagement.ITrackViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public ServerResponse <List<DeliverLocation>> getAllTrackViewById(Integer id) {
        if (id == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccess("获取成功", deliverLocationMapper.selectById(id));

    }

    @Override
    public List<DeliverLocation> getAllTrackViewByTimeSlot(Date time1, Date time2){

        return deliverLocationMapper.selectByTimeSlot(time1,time2);
    }

    @Override
    public ServerResponse <List<DeliverCarLocation>> getAllTrackViewByCarId(Integer CarId) {
        if (CarId == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccess("获取成功", deliverCarLocationMapper.selectByCarId(CarId));

    }

    @Override
    public List<DeliverCarLocation> getAllTrackViewByCarTimeSlot(Date time1, Date time2){

        return deliverCarLocationMapper.selectByCarTimeSlot(time1,time2);
    }

    @Override
    public ServerResponse <List<DeliverCar>> getAllDeliverCarById(Integer id) {
        if (id == null) {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccess("获取成功",deliverCarMapper.selectByPrimaryKey(id));

    }
    @Override
    public  ServerResponse <List<DeliverInformation>> getAllDeliverInformationById(Integer id) {
        if(id == null ) {
            return ServerResponse.createByErrorMessage("参数错误，请核对信息");

        } else {
            return ServerResponse.createBySuccess("获取成功",deliverInformationMapper.selectByPrimaryKey(id));
        }
    }




}
