package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.activiti;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.SupervisionMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.DataGrid;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.Supervision;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.SupervisionTask;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.SupervisionTaskVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.activiti.IActivitiService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-8-25.
 */
@Service("iActivitiService")
public class ActivitiServiceImpl implements IActivitiService{

    @Autowired
    private SupervisionMapper supervisionMapper;
    @Autowired
    IdentityService identityservice;
    @Autowired
    RuntimeService runtimeservice;
    @Autowired
    TaskService taskservice;

    @Override
    public ProcessInstance startWorkflow(Supervision supervision, Integer userid, Map<String, Object> variables) {
        supervision.setUserId(userid);
        supervisionMapper.insert(supervision);
        String businesskey=String.valueOf(supervision.getId());
        identityservice.setAuthenticatedUserId(userid.toString());
        ProcessInstance instance=runtimeservice.startProcessInstanceByKey("process",businesskey,variables);
        System.out.println(businesskey);
        String instanceid=instance.getId();
        supervision.setProcessInstanceId(instanceid);
        supervisionMapper.updateByPrimaryKeySelective(supervision);
        return instance;
    }

    @Override
    public List<SupervisionTask> getpagedepttask(String userid, int firstrow, int rowcount,String group,String name) {
        List<SupervisionTask> results=new ArrayList<SupervisionTask>();
        List<Task> tasks=taskservice.createTaskQuery().taskCandidateGroup(group).taskName(name).listPage(firstrow, rowcount);
        for(Task task:tasks){
            String instanceid=task.getProcessInstanceId();
            ProcessInstance ins=runtimeservice.createProcessInstanceQuery().processInstanceId(instanceid).singleResult();
            String businesskey=ins.getBusinessKey();
            if(!businesskey.equals("null")) {
                Supervision supervision = supervisionMapper.selectByPrimaryKey(Integer.parseInt(businesskey));
                SupervisionTask supervisionTask = new SupervisionTask(
                        supervision.getId(), supervision.getProcessInstanceId(), supervision.getUserId(), supervision.getDetails(), supervision.getPlan(), supervision.getResult(), supervision.getCreateTime());
                supervisionTask.setTask(task);
                results.add(supervisionTask);
            }
        }
        return results;
    }

    @Override
    public int getalldepttask(String userid,String group,String name) {
        List<Task> tasks=taskservice.createTaskQuery().taskCandidateGroup(group).taskName(name).list();
        return tasks.size();
    }

    @Override
    public boolean insertPlan(String taskid,String plan){
         int count = supervisionMapper.updatePlanByProsessid(taskid,plan);
         if(count>0)
             return true;
         return false;
    }

    @Override
    public boolean insertResult(String taskid,String result){
        int count = supervisionMapper.updateResultByProsessid(taskid,result);
        if(count>0)
            return true;
        return false;
    }

    public List<String> getHighLightedFlows(
            ProcessDefinitionEntity processDefinitionEntity,
            List<HistoricActivityInstance> historicActivityInstances) {

        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
        for (int i = 0; i < historicActivityInstances.size(); i++) {// 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i)
                            .getActivityId());// 得 到节点定义的详细信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            if ((i + 1) >= historicActivityInstances.size()) {
                break;
            }
            ActivityImpl sameActivityImpl1 = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i + 1)
                            .getActivityId());// 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances
                        .get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances
                        .get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(
                        activityImpl2.getStartTime())) {// 如果第一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
                            .findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {// 有不相同跳出循环
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl
                    .getOutgoingTransitions();// 取出节点的所有出去的线
            for (PvmTransition pvmTransition : pvmTransitions) {// 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition
                        .getDestination();// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }

    public DataGrid<SupervisionTaskVO> getTask(DataGrid<SupervisionTaskVO> grid,
                                               int rowCount,int current,
                                               List<SupervisionTask> results,int totalsize ){
        List<SupervisionTaskVO> tasks = new ArrayList<>();
        for(SupervisionTask supervisionTask:results){
            SupervisionTaskVO task=new SupervisionTaskVO();
            task.setId(supervisionTask.getId());
            task.setCreateTime(supervisionTask.getCreateTime());
            task.setDetails(supervisionTask.getDetails());
            task.setPlan(supervisionTask.getPlan());
            task.setProcess_instance_id(supervisionTask.getProcessInstanceId());
            task.setProcessdefid(supervisionTask.getTask().getParentTaskId());
            task.setProcessinstanceid(supervisionTask.getProcessInstanceId());
            task.setResult(supervisionTask.getResult());
            task.setTaskcreatetime(supervisionTask.getTask().getCreateTime());
            task.setTaskid(supervisionTask.getTask().getId());
            task.setTaskname(supervisionTask.getTask().getName());
            task.setUser_id(supervisionTask.getUserId().toString());
            tasks.add(task);
        }

        grid.setRowCount(rowCount);
        grid.setCurrent(current);
        grid.setTotal(totalsize);
        grid.setRows(tasks);
        return grid;
    }
}
