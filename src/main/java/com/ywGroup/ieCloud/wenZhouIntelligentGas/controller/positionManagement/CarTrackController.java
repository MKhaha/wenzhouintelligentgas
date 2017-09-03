package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.positionManagement;


import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.positionManagement.ITrackViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lanmeiniu on 2017/8/29.
 * table_name:deliver_car deliver_car_location
 * do what : 呈现给前端 车辆轨迹信息以及当前最近位置信息
 */
@Controller
@RequestMapping("/positionManagement/car")
public class CarTrackController {

    @Autowired
    private ITrackViewService iTrackViewService;



    /***
     * 配送车辆轨迹信息
     * 根据deliverCarId 起始时间 查询 deliver_car_location
     * table_name :deliver_car_location
     * @param deliverCarId
     * @param beginTime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "searchTrack.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchCarTrack(@RequestParam(value = "deliverCarId",defaultValue = "0") Integer deliverCarId,
                                         @RequestParam(value = "beginTime",defaultValue = "")String beginTime,
                                         @RequestParam(value = "endTime",defaultValue = "")String endTime) {
        Date date1= null;
        Date date2= null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        if (!beginTime.equals("")&&!endTime.equals("")){
            try {
                date1=sdf.parse(beginTime);
                date2=sdf.parse(endTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return iTrackViewService.getAllCarTrackView(deliverCarId,date1,date2);
    }

    /**
     * 配送车辆详细信息并且显示最近位置
     *table_name: deliver_car
     */
    @RequestMapping(value = "searchTrackLatestById.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchTrackLatestById
    (@RequestParam(value = "id",defaultValue = "0")Integer id) {
        return iTrackViewService.searchTrackLatestById(id);

    }


}

