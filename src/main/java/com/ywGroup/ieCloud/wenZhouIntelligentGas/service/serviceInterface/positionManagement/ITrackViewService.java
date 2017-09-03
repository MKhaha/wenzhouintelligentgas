package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.positionManagement;


import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCar;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCarLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.DeliverCarVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.DeliverInformationVO;

import java.util.Date;
import java.util.List;

/**
 * Created by lanmeiniu on 2017/8/29.
 */
public interface ITrackViewService {

    ServerResponse <List<DeliverLocation>> getAllTrackView(Integer deliverId, Date time1, Date time2);

    ServerResponse<List<DeliverInformationVO>> searchPersonLatestById(Integer id);

    ServerResponse <List<DeliverCarLocation>> getAllCarTrackView(Integer deliverCarId,Date beginTime, Date endTime);

    ServerResponse<List<DeliverCarVO>> searchTrackLatestById (Integer id);





}
