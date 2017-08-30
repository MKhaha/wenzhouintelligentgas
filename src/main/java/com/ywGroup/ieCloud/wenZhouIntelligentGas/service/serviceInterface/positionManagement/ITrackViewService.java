package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.positionManagement;


import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCar;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCarLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverLocation;

import java.util.Date;
import java.util.List;

/**
 * Created by lanmeiniu on 2017/8/29.
 */
public interface ITrackViewService {

    ServerResponse <List<DeliverLocation>> getAllTrackViewById(Integer id);

    List<DeliverLocation> getAllTrackViewByTimeSlot(Date time1, Date time2);

    ServerResponse <List<DeliverCarLocation>> getAllTrackViewByCarId(Integer CarId);

    List<DeliverCarLocation> getAllTrackViewByCarTimeSlot(Date time1, Date time2);

    ServerResponse <List<DeliverCar>> getAllDeliverCarById(Integer id);

    ServerResponse <List<DeliverInformation>> getAllDeliverInformationById(Integer id);



}
