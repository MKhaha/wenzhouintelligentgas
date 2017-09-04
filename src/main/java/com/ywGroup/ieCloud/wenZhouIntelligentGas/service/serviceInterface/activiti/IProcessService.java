package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.activiti;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Process;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.ProcessVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017-9-4.
 */
public interface IProcessService {
    void draw(List list, HttpServletResponse response);
    ServerResponse<String> addProcess(Process process);
    ServerResponse<String> delProcess(Integer id);
    ServerResponse<String> updateProcess(Process process);
    ServerResponse<List<ProcessVO>> select(String name, Integer founderId);
}
