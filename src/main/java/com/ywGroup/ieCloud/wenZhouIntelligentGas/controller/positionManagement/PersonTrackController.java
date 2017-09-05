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
 * Created by lanmeiniu on 2017/9/3.
 * do what : 呈现给前端,配送人员轨迹信息以及详细信息中添加最近位置
 * table_name: deliver_information deliver_location
 */

@Controller
@RequestMapping("/positionManagement/person")
public class PersonTrackController {

    @Autowired
    private ITrackViewService iTrackViewService;

    /**
     * 配送人员轨迹信息
     * 根据deliverId 起始时间 查询 deliver_location
     * table_name: deliver_location
     * 配送人员轨迹信息
     * @param deliverId
     * @param beginTime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "searchTrack.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchTrack(@RequestParam(value = "deliverId",defaultValue = "0") Integer deliverId,
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
        return iTrackViewService.getAllTrackView(deliverId,date1,date2);
    }

    /**
     * 配送人员详细信息并且显示最近的位置信息
     * table_name：deliver_information
     * @param id
     * @return
     */
    @RequestMapping(value = "searchLatestById.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchLatestById
    (@RequestParam(value = "id",defaultValue = "0")Integer id) {
        return iTrackViewService.searchPersonLatestById(id);
    }
    /**
     *地区区域统计信息
     */
    @RequestMapping(value = "numberOfDeliverInformationRegions.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse numberOfDeliverInformationRegions(){
        return iTrackViewService.numberOfDeliverInformationRegions();
    }


}
