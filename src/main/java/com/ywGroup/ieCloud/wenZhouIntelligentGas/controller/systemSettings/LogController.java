package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.systemSettings;

import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ResponseCode;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017-8-18.
 */
@Controller
@RequestMapping("log")
public class LogController {

    @Autowired
    private ILogService iLogService;

    private static final String SEARCH_BY_USER = "searchByUser";
    private static final String SEARCH_BY_IP = "searchByIp";
    private static final String SEARCH_BY_METHOD_NAME = "searchMethodName";
    private static final String SEARCH_ALL = "searchAll";



    //日志查询
    @RequestMapping(value = "searchLog.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> searchLog(
            @RequestParam("searchType") String searchType,
            @RequestParam("keyWord") String keyWord,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        switch (searchType) {
            case SEARCH_ALL:
                return iLogService.getAllLogInfo(pageNum, pageSize);
            case SEARCH_BY_USER:
                return iLogService.getAllLogInfoByUser(keyWord, pageNum, pageSize);
            case SEARCH_BY_IP:
                return iLogService.getAllLogInfoByIp(keyWord, pageNum, pageSize);
            case SEARCH_BY_METHOD_NAME:
                return iLogService.getAllLogInfoByMethodName(keyWord, pageNum, pageSize);
            default:
                return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
    }
}



