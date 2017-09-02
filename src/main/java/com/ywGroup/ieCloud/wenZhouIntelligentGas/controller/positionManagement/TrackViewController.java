package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.positionManagement;


import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.positionManagement.ITrackViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by lanmeiniu on 2017/8/29.
 *
 */
@Controller
@RequestMapping("/positionManagement/track")
public class TrackViewController {

    @Autowired
    private ITrackViewService iTrackViewService;


    /**
     * 配送车辆详细信息并且显示最近轨迹信息
     *table_name: deliver_car
     */
    @RequestMapping(value = "searchTrackLatestById.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchTrackLatestById
    (@RequestParam(value = "id",defaultValue = "0")Integer id) {
        return iTrackViewService.searchTrackLatestById(id);

    }

    /**
     * 配送人员详细信息并且显示最近的轨迹信息
     * table_name：deliver_information
     */
    @RequestMapping(value = "searchPersonLatestById.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchPersonLatestById
    (@RequestParam(value = "id",defaultValue = "0")Integer id) {
        return iTrackViewService.searchPersonLatestById(id);
    }

}

