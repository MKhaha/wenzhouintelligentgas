package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.positionManagement;


import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCar;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverCarLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverInformation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.DeliverLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.positionManagement.ITrackViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lanmeiniu on 2017/8/29.
 * 根据deliver_location 表中的 id 时间段进行信息查询
 */
@Controller
@RequestMapping("/positionManagement/track")
public class TrackViewController {

    @Autowired
    private ITrackViewService iTrackViewService;


    /**配送位置信息通过id查询
     * table_name：deliver_location
     * search_type: id
     * @return
     */
    @RequestMapping(value = "searchTrackById.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DeliverLocation>> searchTrackById (Integer id) {
        return iTrackViewService.getAllTrackViewById(id);
    }

    /**配送位置信息通过时间段查询
     * teble_name:deliver_location
     * search_type:timeslot
     * @return
     */
    @RequestMapping(value = "searchTrackByTimeSlot.do",method = RequestMethod.POST)
    @ResponseBody
    public List<DeliverLocation> searchTrackByTimeSlot (String time1, String time2) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        try {
            Date date1=sdf.parse(time1);
            Date date2=sdf.parse(time2);
            return iTrackViewService.getAllTrackViewByTimeSlot(date1,date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**配送车辆位置信息通过id查询
     * table_name：deliver_car_location
     * search_type: CarId
     * @return
     */
    @RequestMapping(value = "searchTrackByCarId.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DeliverCarLocation>> searchTrackByCarId (Integer CarId) {
        return iTrackViewService.getAllTrackViewByCarId(CarId);
    }

   /**配送车辆位置信息通过时间段查询
     * teble_name:deliver_car_location
     * search_type:TimeSlot
     * @return
     */
    @RequestMapping(value = "searchTrackByCarTimeSlot.do",method = RequestMethod.POST)
    @ResponseBody
    public List<DeliverCarLocation> searchTrackByCarTimeSlot (String time1, String time2) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        try {
            Date date1=sdf.parse(time1);
            Date date2=sdf.parse(time2);
            return iTrackViewService.getAllTrackViewByCarTimeSlot(date1,date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
    /**配送车辆信息通过id查询
     * teble_name:deliver_car
     * search_type:id
     * @return
     */
    @RequestMapping(value = "searchCarTrackById.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DeliverCar>> searchCarTrackById (Integer id) {
        return iTrackViewService.getAllDeliverCarById(id);
    }

    /**配送人员信息通过id查询
     * teble_name:deliver_information
     * search_type:id
     * @return
     */
    @RequestMapping(value = "searchInformationById.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DeliverInformation>> searchInformationById (Integer id) {
        return iTrackViewService.getAllDeliverInformationById(id);
    }

}

