package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.activiti;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.SupervisionMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.*;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.Process;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.activiti.IActivitiService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;
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
@RequestMapping("/activiti/")
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
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getprocesslists.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getlist(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        int firstrow=(pageNumber-1)*pageSize;
        List<ProcessDefinition> list=rep.createProcessDefinitionQuery().listPage(firstrow, pageSize);
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
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(mylist);
        pageHelperUtil.setTotal(total);
        return ServerResponse.createBySuccess("获取成功",pageHelperUtil);
    }

    /**
     * 查看当前用户发起的流程
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/setupprocess.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setupprocess(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        int firstrow=(pageNumber-1)*pageSize;
        AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        ProcessInstanceQuery query = runservice.createProcessInstanceQuery();
        int total= (int) query.count();
        List<ProcessInstance> a = query.processDefinitionKey("process").involvedUser(administatorVO.getId().toString()).listPage(firstrow, pageSize);
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
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(list);
        pageHelperUtil.setTotal(total);
        return ServerResponse.createBySuccess("获取成功",pageHelperUtil);
    }

    /**
     * 获取当前用户参与的流程
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/involvedprocess.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse allexeution(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        int firstrow=(pageNumber-1)*pageSize;
        AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        ProcessInstanceQuery query = runservice.createProcessInstanceQuery();
        int total= (int) query.count();
        List<ProcessInstance> a = query.processDefinitionKey("process").involvedUser(administatorVO.getId().toString()).listPage(firstrow, pageSize);
        List<RunningProcess> list=new ArrayList<RunningProcess>();
        for(ProcessInstance p:a){
            RunningProcess process=new RunningProcess();
            process.setActivityid(p.getActivityId());
            process.setBusinesskey(p.getBusinessKey());
            process.setExecutionid(p.getId());
            process.setProcessInstanceid(p.getProcessInstanceId());
            list.add(process);
        }
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(list);
        pageHelperUtil.setTotal(total);
        return ServerResponse.createBySuccess("获取成功",pageHelperUtil);
    }

    /**
     * 获取当前用户已经结束的流程
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getfinishprocess.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getHistory(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                               @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        int firstrow=(pageNumber-1)*pageSize;
        AdministatorVO administatorVO = (AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        HistoricProcessInstanceQuery process = histiryservice.createHistoricProcessInstanceQuery().
                                                        processDefinitionKey("process").
                                                            startedBy(administatorVO.getId().toString()).
                                                                finished();
        int total= (int) process.count();
        List<HistoricProcessInstance> info = process.listPage(firstrow, pageSize);
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
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(list);
        pageHelperUtil.setTotal(total);
        return ServerResponse.createBySuccess("获取成功",pageHelperUtil);
    }

    /**
     * 画出流程的状态
     * @param executionid
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/traceprocess.do")//,method = RequestMethod.POST
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
     * @param processInstanceid
     * @return
     */
    @RequestMapping(value = "/processinfo.do",method = RequestMethod.POST)
    @ResponseBody
    public List<HistoricActivityInstance> processinfo(String processInstanceid){
        List<HistoricActivityInstance> his = histiryservice.createHistoricActivityInstanceQuery().processInstanceId(processInstanceid).orderByHistoricActivityInstanceStartTime().asc().list();
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
        if(org.apache.commons.lang3.StringUtils.isBlank(supervision.getDetails()))
            return ServerResponse.createByErrorMessage("提交的问题为空");
        Map<String,Object> variables=new HashMap<String, Object>();
        variables.put("userid", administatorVO.getId());
        ProcessInstance ins=iActivitiService.startWorkflow(supervision, administatorVO.getId(), variables);
        System.out.println("流程id"+ins.getId()+"已启动");
        return ServerResponse.createBySuccessMessage("发起成功");
    }

    /**
     * 获取处于"安全监管部，拟定方案"阶段的流程
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/fanganlist.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse fanganlist(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(new ArrayList<SupervisionTaskVO>());
        pageHelperUtil.setTotal(0);
        //先做权限检查，对于没有"安全监管部，拟定方案"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "监管部";//roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("监管部")){
            int firstrow=(pageNumber-1)*pageSize;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(firstrow,pageSize,"监管部","拟定方案");
            int totalsize=iActivitiService.getalldepttask("监管部","拟定方案");
            return ServerResponse.createBySuccess("获取成功",iActivitiService.getTask(pageHelperUtil,pageSize,pageNumber,results,totalsize));
        }
        return ServerResponse.createByErrorMessage("没有权限查看");
    }

    /**
     * 获取处于"审核阶段"的流程
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shenhelist.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse shenhelist(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(new ArrayList<SupervisionTaskVO>());
        pageHelperUtil.setTotal(0);
        //先做权限检查，对于没有"审核阶段"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "总经理";//roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("总经理")){
            int firstrow=(pageNumber-1)*pageSize;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(firstrow,pageSize,"总经理","上级领导审核");
            int totalsize=iActivitiService.getalldepttask("总经理","上级领导审核");
            return ServerResponse.createBySuccess("获取成功",iActivitiService.getTask(pageHelperUtil,pageSize,pageNumber,results,totalsize));
        }
        return ServerResponse.createByErrorMessage("没有权限查看");
    }

    /**
     * 获取处于实施的流程
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shishilist.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse shishilist(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(new ArrayList<SupervisionTaskVO>());
        pageHelperUtil.setTotal(0);
        //先做权限检查，对于没有"审核阶段"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "实施部";//roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("实施部")){
            int firstrow=(pageNumber-1)*pageSize;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(firstrow,pageSize,"实施部","执行部门实施");
            int totalsize=iActivitiService.getalldepttask("实施部","执行部门实施");
            return ServerResponse.createBySuccess("获取成功",iActivitiService.getTask(pageHelperUtil,pageSize,pageNumber,results,totalsize));
        }
        return ServerResponse.createByErrorMessage("没有权限查看");
    }

    /**
     * 获取处于结果审核的
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/jieguoList.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse jieguoList(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageHelperUtil pageHelperUtil=new PageHelperUtil();
        pageHelperUtil.setPageNum(pageNumber);
        pageHelperUtil.setPageSize(pageSize);
        pageHelperUtil.setList(new ArrayList<SupervisionTaskVO>());
        pageHelperUtil.setTotal(0);
        //先做权限检查，对于没有"审核阶段"权限的用户,直接返回空
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "总经理";//roleMapper.checkName(administatorVO.getRoleNumber());
        if (roleName.equals("总经理")){
            int firstrow=(pageNumber-1)*pageSize;
            List<SupervisionTask> results=iActivitiService.getpagedepttask(firstrow,pageSize,"总经理","处理结果审核");
            int totalsize=iActivitiService.getalldepttask("总经理","处理结果审核");
            return ServerResponse.createBySuccess("获取成功",iActivitiService.getTask(pageHelperUtil,pageSize,pageNumber,results,totalsize));
        }
        return ServerResponse.createByErrorMessage("没有权限查看");
    }

    /**
     * 提交方案，流程流向下一节点
     * @param taskid
     * @param plan
     * @return
     */
    @RequestMapping(value = "/task/tijiaofa.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse tijiaofaTask(String taskid,String plan){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "监管部";//roleMapper.checkName(administatorVO.getRoleNumber());
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
    public ServerResponse shenhefaTask(String taskid,String checkok){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "总经理";//roleMapper.checkName(administatorVO.getRoleNumber());
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
    public ServerResponse tiajiaojgTask(String taskid,String result){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "实施部";//roleMapper.checkName(administatorVO.getRoleNumber());
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
    public ServerResponse shenhejgTask(String taskid,String chuliok){
        AdministatorVO administatorVO=(AdministatorVO) httpSession.getAttribute(Const.CURRENT_USER);
        String roleName = "总经理";//roleMapper.checkName(administatorVO.getRoleNumber());
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
