package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.LogMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Log;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.ILogService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanmeiniu on 2017/8/28.
 */
@Service("iLogService")
public class LogServiceImpl implements ILogService{

    @Autowired
    private LogMapper logMapper;

    @Override
    public  ServerResponse<String> insertLogToDatabase(Log log){
        if (0 == logMapper.insertSelective(log)) {
            return ServerResponse.createByErrorMessage("无法添加日志记录，请查明原因");
        } else {
            return ServerResponse.createBySuccessMessage("日志添加成功");
        }
    }

    /**
     * 查询所有日志记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getAllLogInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Log> LogInfoList = logMapper.selectAll();
        if(CollectionUtils.isEmpty(LogInfoList)) {
            return ServerResponse.createByErrorMessage("没有日志记录");
        }
        PageInfo pageResult =new PageInfo(LogInfoList);
        pageResult.setList(LogInfoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 按照操作人，进行日志查询
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getAllLogInfoByUser(String user, int pageNum, int pageSize ){
        PageHelper.startPage(pageNum, pageSize);
        List<Log> LogInfoList = logMapper.selectByUser(user);
        if(CollectionUtils.isEmpty(LogInfoList)) {
            return ServerResponse.createBySuccessMessage("没有找到对应用户的日志信息");
        }
        PageInfo pageResult = new PageInfo(LogInfoList);
        pageResult.setList(LogInfoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 按照操作ip地址进行，查询
     * @param ip
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getAllLogInfoByIp(String ip, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);

        List<Log> LogInfoList = logMapper.selectByIp(ip);

        if(CollectionUtils.isEmpty(LogInfoList)) {
            return ServerResponse.createBySuccessMessage("没有找到对应用户的日志信息");
        }
        PageInfo pageResult = new PageInfo(LogInfoList);
        pageResult.setList(LogInfoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 按照
     * @param methodName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getAllLogInfoByMethodName(String methodName, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Log> LogInfoList = logMapper.selectByMethodName(methodName);
        if(CollectionUtils.isEmpty(LogInfoList)) {
            return ServerResponse.createBySuccessMessage("没有找到对应用户的日志信息");
        }
        PageInfo pageResult = new PageInfo(LogInfoList);
        pageResult.setList(LogInfoList);
        return ServerResponse.createBySuccess(pageResult);
    }
}
