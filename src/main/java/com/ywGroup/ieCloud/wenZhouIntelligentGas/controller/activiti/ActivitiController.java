package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.activiti;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.SupervisionMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.*;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.Process;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.activiti.IActivitiService;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-8-25.
 */
@Controller
@RequestMapping("/activiti")
public class ActivitiController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    RepositoryService rep;
    @Autowired
    RuntimeService runservice;
    @Autowired
    TaskService taskservice;
    @Autowired
    HistoryService histiryservice;
    @Autowired
    private IActivitiService iActivitiService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private SupervisionMapper supervisionMapper;
    /**
     * 获取已经部署的工作流
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping(value = "/getprocesslists.do",method = RequestMethod.POST)
    @ResponseBody
    public DataGrid<Process> getlist(@RequestParam(value = "current",defaultValue = "1") int current,
                                     @RequestParam(value = "rowCount",defaultValue = "10") int rowCount){
        int firstrow=(current-1)*rowCount;
        List<ProcessDefinition> list=rep.createProcessDefinitionQuery().listPage(firstrow, rowCount);
        int total=rep.createProcessDefinitionQuery().list().size();
        List<Process> mylist=new ArrayList<Process>();
        for(int i=0;i<list.size();i++)
        {
            Process p=new Process();
            p.setDeploymentId(list.get(i).getDeploymentId());
            p.setId(list.get(i).getId());
            p.setKey(list.get(i).getKey());
            p.setName(list.get(i).getName());
            p.setResourceName(list.get(i).getResourceName());
            p.setDiagramresourcename(list.get(i).getDiagramResourceName());
            mylist.add(p);
        }
        DataGrid<Process> grid=new DataGrid<Process>();
        grid.setCurrent(current);
        grid.setRowCount(rowCount);
        grid.setRows(mylist);
        grid.setTotal(total);
        return grid;
    }

    /**
     * 查看当前用户发起的流程
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping("/setupprocess.do")
    @ResponseBody
    public DataGrid<RunningProcess> setupprocess(@RequestParam(value = "current",defaultValue = "1") int current,
                                                 @RequestParam(value = "rowCount",defaultValue = "10") int rowCount){
        int firstrow=(current-1)*rowCount;
        AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        ProcessInstanceQuery query = runservice.createProcessInstanceQuery();
        int total= (int) query.count();
        List<ProcessInstance> a = query.processDefinitionKey("process").involvedUser(administatorVO.getId().toString()).listPage(firstrow, rowCount);
        List<RunningProcess> list=new ArrayList<RunningProcess>();
        for(ProcessInstance p:a){
            RunningProcess process=new RunningProcess();
            process.setActivityid(p.getActivityId());
            process.setBusinesskey(p.getBusinessKey());
            process.setExecutionid(p.getId());
            process.setProcessInstanceid(p.getProcessInstanceId());
            Supervision l = supervisionMapper.selectByPrimaryKey(Integer.parseInt(p.getBusinessKey()));
            if(l.getUserId()==administatorVO.getId())
                list.add(process);
            else
                continue;
        }
        DataGrid<RunningProcess> grid=new DataGrid<RunningProcess>();
        grid.setCurrent(current);
        grid.setRowCount(rowCount);
        grid.setTotal(total);
        grid.setRows(list);
        return grid;
    }

    /**
     * 获取当前用户参与的流程
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping("/involvedprocess.do")
    @ResponseBody
    public DataGrid<RunningProcess> allexeution(@RequestParam(value = "current",defaultValue = "1") int current,
                                                @RequestParam(value = "rowCount",defaultValue = "10") int rowCount){
        int firstrow=(current-1)*rowCount;
        AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        ProcessInstanceQuery query = runservice.createProcessInstanceQuery();
        int total= (int) query.count();
        List<ProcessInstance> a = query.processDefinitionKey("process").involvedUser(administatorVO.getId().toString()).listPage(firstrow, rowCount);
        List<RunningProcess> list=new ArrayList<RunningProcess>();
        for(ProcessInstance p:a){
            RunningProcess process=new RunningProcess();
            process.setActivityid(p.getActivityId());
            process.setBusinesskey(p.getBusinessKey());
            process.setExecutionid(p.getId());
            process.setProcessInstanceid(p.getProcessInstanceId());
            list.add(process);
        }
        DataGrid<RunningProcess> grid=new DataGrid<RunningProcess>();
        grid.setCurrent(current);
        grid.setRowCount(rowCount);
        grid.setTotal(total);
        grid.setRows(list);
        return grid;
    }

    /**
     * 获取当前用户已经结束的流程
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping("/getfinishprocess.do")
    @ResponseBody
    public DataGrid<HistoryProcess> getHistory(@RequestParam(value = "current",defaultValue = "1") int current,
                                               @RequestParam(value = "rowCount",defaultValue = "10") int rowCount){
        int firstrow=(current-1)*rowCount;
        AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        HistoricProcessInstanceQuery process = histiryservice.createHistoricProcessInstanceQuery().
                                                        processDefinitionKey("process").
                                                            startedBy(administatorVO.getId().toString()).
                                                                finished();
        int total= (int) process.count();
        List<HistoricProcessInstance> info = process.listPage(firstrow, rowCount);
        List<HistoryProcess> list=new ArrayList<HistoryProcess>();
        for(HistoricProcessInstance history:info){
            HistoryProcess his=new HistoryProcess();
            String bussinesskey=history.getBusinessKey();
            Supervision supervision = supervisionMapper.selectByPrimaryKey(Integer.parseInt(bussinesskey));
            his.setSupervision(supervision);
            his.setBusinessKey(bussinesskey);
            his.setProcessDefinitionId(history.getProcessDefinitionId());
            list.add(his);
        }
        DataGrid<HistoryProcess> grid=new DataGrid<HistoryProcess>();
        grid.setCurrent(current);
        grid.setRowCount(rowCount);
        grid.setTotal(total);
        grid.setRows(list);
        return grid;
    }

    /**
     * 画出流程的状态
     * @param executionid
     * @param response
     * @throws Exception
     */
    @RequestMapping("/traceprocess.do")
    public void traceprocess(String executionid,HttpServletResponse response) throws Exception{
        ProcessInstance process=runservice.createProcessInstanceQuery().processInstanceId(executionid).singleResult();
        BpmnModel bpmnmodel=rep.getBpmnModel(process.getProcessDefinitionId());
        List<String> activeActivityIds=runservice.getActiveActivityIds(executionid);
        DefaultProcessDiagramGenerator gen=new DefaultProcessDiagramGenerator();
        // 获得历史活动记录实体（通过启动时间正序排序，不然有的线可以绘制不出来）
        List<HistoricActivityInstance> historicActivityInstances = histiryservice
                .createHistoricActivityInstanceQuery().executionId(executionid)
                .orderByHistoricActivityInstanceStartTime().asc().list();
        // 计算活动线
        List<String> highLightedFlows = iActivitiService.getHighLightedFlows(
                (ProcessDefinitionEntity) ((RepositoryServiceImpl) rep).getDeployedProcessDefinition(process.getProcessDefinitionId()),
                historicActivityInstances);

        InputStream in=gen.generateDiagram(bpmnmodel, "png", activeActivityIds,highLightedFlows,"宋体","宋体",null,1.0);
        //InputStream in=gen.generateDiagram(bpmnmodel, "png", activeActivityIds);
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(in, output);
    }

    /**
     * 获取已结束流程详情
     * @param processid
     * @return
     */
    @RequestMapping("/processinfo.do")
    @ResponseBody
    public List<HistoricActivityInstance> processinfo(String processid){
        List<HistoricActivityInstance> his = histiryservice.createHistoricActivityInstanceQuery().processInstanceId(processid).orderByHistoricActivityInstanceStartTime().asc().list();
        return his;
    }

    /**
     * 发起一个监管流程
     * @param supervision
     * @return
     */
    @RequestMapping(value="/startProcess.do",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse startProcess(Supervision supervision){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        Map<String,Object> variables=new HashMap<String, Object>();
        variables.put("userid", administatorVO.getId());
        ProcessInstance ins=iActivitiService.startWorkflow(supervision, administatorVO.getId(), variables);
        System.out.println("流程id"+ins.getId()+"已启动");
        return ServerResponse.createBySuccessMessage("发起成功");
    }

    /**
     * 获取处于"安全监管部，拟定方案"阶段的流程
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping(value="/fanganlist.do",method = RequestMethod.POST)
    @ResponseBody
    public DataGrid<SupervisionTaskVO> fanganlist(@RequestParam(value = "current",defaultValue = "1") int current,
                                                       @RequestParam(value = "rowCount",defaultValue = "10") int rowCount) {
        DataGrid<SupervisionTaskVO> grid = new DataGrid<SupervisionTaskVO>();
        grid.setRowCount(rowCount);
        grid.setCurrent(current);
        grid.setTotal(0);
        grid.setRows(new ArrayList<SupervisionTaskVO>());
        //先做权限检查，对于没有"安全监管部，拟定方案"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("监管部")){
            int firstrow=(current-1)*rowCount;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(administatorVO.getId().toString(),firstrow,rowCount,"监管部","拟定方案");
            int totalsize=iActivitiService.getalldepttask(administatorVO.getId().toString(),"监管部","拟定方案");
            return iActivitiService.getTask(grid,rowCount,current,results,totalsize);
        }
        return grid;
    }

    /**
     * 获取处于"审核阶段"的流程
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping(value="/shenhelist.do",method = RequestMethod.POST)
    @ResponseBody
    public DataGrid<SupervisionTaskVO> shenhelist(@RequestParam(value = "current",defaultValue = "1") int current,
                                                       @RequestParam(value = "rowCount",defaultValue = "10") int rowCount) {
        DataGrid<SupervisionTaskVO> grid = new DataGrid<SupervisionTaskVO>();
        grid.setRowCount(rowCount);
        grid.setCurrent(current);
        grid.setTotal(0);
        grid.setRows(new ArrayList<SupervisionTaskVO>());
        //先做权限检查，对于没有"审核阶段"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("总经理")){
            int firstrow=(current-1)*rowCount;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(administatorVO.getId().toString(),firstrow,rowCount,"总经理","上级领导审核");
            int totalsize=iActivitiService.getalldepttask(administatorVO.getId().toString(),"总经理","上级领导审核");
            return iActivitiService.getTask(grid,rowCount,current,results,totalsize);
        }
        return grid;
    }

    /**
     * 获取处于实施的流程
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping(value="/shishilist.do",method = RequestMethod.POST)
    @ResponseBody
    public DataGrid<SupervisionTaskVO> shishilist(@RequestParam(value = "current",defaultValue = "1") int current,
                                                  @RequestParam(value = "rowCount",defaultValue = "10") int rowCount) {
        DataGrid<SupervisionTaskVO> grid = new DataGrid<SupervisionTaskVO>();
        grid.setRowCount(rowCount);
        grid.setCurrent(current);
        grid.setTotal(0);
        grid.setRows(new ArrayList<SupervisionTaskVO>());
        //先做权限检查，对于没有"审核阶段"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("实施部")){
            int firstrow=(current-1)*rowCount;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(administatorVO.getId().toString(),firstrow,rowCount,"实施部","执行部门实施");
            int totalsize=iActivitiService.getalldepttask(administatorVO.getId().toString(),"实施部","执行部门实施");
            return iActivitiService.getTask(grid,rowCount,current,results,totalsize);
        }
        return grid;
    }

    /**
     * 获取处于结果审核的
     * @param current
     * @param rowCount
     * @return
     */
    @RequestMapping(value="/jieguoList.do",method = RequestMethod.POST)
    @ResponseBody
    public DataGrid<SupervisionTaskVO> jieguoList(@RequestParam(value = "current",defaultValue = "1") int current,
                                                  @RequestParam(value = "rowCount",defaultValue = "10") int rowCount) {
        DataGrid<SupervisionTaskVO> grid = new DataGrid<SupervisionTaskVO>();
        grid.setRowCount(rowCount);
        grid.setCurrent(current);
        grid.setTotal(0);
        grid.setRows(new ArrayList<SupervisionTaskVO>());
        //先做权限检查，对于没有"审核阶段"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("总经理")){
            int firstrow=(current-1)*rowCount;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(administatorVO.getId().toString(),firstrow,rowCount,"总经理","处理结果审核");
            int totalsize=iActivitiService.getalldepttask(administatorVO.getId().toString(),"总经理","处理结果审核");
            return iActivitiService.getTask(grid,rowCount,current,results,totalsize);
        }
        return grid;
    }

    /**
     * 提交方案，流程流向下一节点
     * @param taskid
     * @param plan
     * @return
     */
    @RequestMapping(value = "/task/tijiaofa.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse tijiaofa(String taskid,String plan){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        Task task=taskservice.createTaskQuery().taskId(taskid).singleResult();
        String instanceid=task.getProcessInstanceId();
        if(roleName.equals("监管部")&&iActivitiService.insertPlan(instanceid,plan)){
            taskservice.claim(taskid, administatorVO.getId().toString());
            taskservice.complete(taskid);
            return ServerResponse.createBySuccessMessage("提交成功");
        }
        return ServerResponse.createByErrorMessage("无权操作");
    }

    /**
     * 审核方案，处理提交后，流向下一节点
     * @param taskid
     * @param checkok
     * @return
     */
    @RequestMapping(value = "/task/shenhefa.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse shenhefa(String taskid,String checkok){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        Map<String,Object> variables=new HashMap<String,Object>();
        variables.put("checkok", checkok);
        if(roleName.equals("总经理")){
            taskservice.claim(taskid, administatorVO.getId().toString());
            taskservice.complete(taskid,variables);
            return ServerResponse.createBySuccessMessage("处理成功");
        }
        return ServerResponse.createByErrorMessage("无权操作");
    }

    /**
     * 提交结果，流程流向下一节点
     * @param taskid
     * @param result
     */
    @RequestMapping(value = "/task/tiajiaojg.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse tiajiaojg(String taskid,String result){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        Task task=taskservice.createTaskQuery().taskId(taskid).singleResult();
        String instanceid=task.getProcessInstanceId();
        if(roleName.equals("实施部")&&iActivitiService.insertResult(instanceid,result)){
            taskservice.claim(taskid, administatorVO.getId().toString());
            taskservice.complete(taskid);
            return ServerResponse.createBySuccessMessage("提交成功");
        }
        return ServerResponse.createByErrorMessage("无权操作");
    }

    /**
     * 处理结果提交，处理提交后，流向下一节点
     * @param taskid
     * @param chuliok
     * @return
     */
    @RequestMapping(value = "/task/shenhejg.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse shenhejg(String taskid,String chuliok){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = roleMapper.checkName(administatorVO.getRoleNumber());
        Map<String,Object> variables=new HashMap<String,Object>();
        variables.put("chuliok", chuliok);
        if(roleName.equals("总经理")){
            taskservice.claim(taskid, administatorVO.getId().toString());
            taskservice.complete(taskid,variables);
            return ServerResponse.createBySuccessMessage("处理成功");
        }
        return ServerResponse.createByErrorMessage("无权操作");
    }


}
