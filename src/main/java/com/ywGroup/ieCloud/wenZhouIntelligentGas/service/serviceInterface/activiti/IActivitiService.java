package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.activiti;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.DataGrid;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.Supervision;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.SupervisionTask;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.SupervisionTaskVO;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-8-25.
 */
public interface IActivitiService {
    ProcessInstance startWorkflow(Supervision supervision,Integer userid,Map<String ,Object> variables);
    List<SupervisionTask> getpagedepttask(String userid, int firstrow, int rowcount,String group,String name);
    int getalldepttask(String userid,String group,String name);
    DataGrid<SupervisionTaskVO> getTask(DataGrid<SupervisionTaskVO> grid, int rowCount, int current, List<SupervisionTask> results, int totalsize );
    boolean insertPlan(String taskid,String plan);
    boolean insertResult(String taskid,String result);
    List<String> getHighLightedFlows(ProcessDefinitionEntity processDefinitionEntity, List<HistoricActivityInstance> historicActivityInstances);
}
