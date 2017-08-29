package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings;

import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Log;

/**
 * Created by lanmeiniu on 2017/8/28.
 */

public interface ILogService {

    ServerResponse<String> insertLogToDatabase(Log log);

    ServerResponse<PageInfo> getAllLogInfo(int pageNum, int pageSize);

    ServerResponse<PageInfo> getAllLogInfoByUser(String user, int pageNum, int pageSize );
    ServerResponse<PageInfo> getAllLogInfoByIp(String ip, int pageNum, int pageSize);
    ServerResponse<PageInfo> getAllLogInfoByMethodName(String assetName, int pageNum, int pageSize);




}
