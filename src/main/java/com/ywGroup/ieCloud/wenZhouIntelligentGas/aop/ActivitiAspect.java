package com.ywGroup.ieCloud.wenZhouIntelligentGas.aop;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.AliyunSms;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.AdministratorMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.SupervisionMapper;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-8-30.
 */
@Aspect
@Component
public class ActivitiAspect {

    @Autowired
    TaskService taskservice;

    @Autowired
    SupervisionMapper supervisionMapper;
    @Autowired
    AdministratorMapper administratorMapper;

    @Autowired
    private AliyunSms aliyunSmsService;

    private static int userid = 0;

    @Pointcut("execution(* com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.activiti.ActivitiController.*Task(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint point){
        Object[] objects = point.getArgs();
        Task task=taskservice.createTaskQuery().taskId(objects[0].toString()).singleResult();
        String instanceid=task.getProcessInstanceId();
        userid = supervisionMapper.selectUseridByProsessid(instanceid);
    }

    @AfterReturning(pointcut = "pointcut()")
    public void afterReturn(JoinPoint point){
        String methodName = point.getSignature().getName();
        String operatingName  = "";
        boolean b = false;
        switch (methodName){
            case "tijiaofaTask" :operatingName = "拟定";b=true;
                                 break;
            case "shenhefaTask" :operatingName = "审核";b=true;
                                 break;
            case "tiajiaojgTask" :operatingName = "提交";
                                 break;
            case "shenhejgTask" :operatingName = "审核";
                                 break;
                         default:break;
        }
        String mobile = administratorMapper.selectMobileByid(userid);
        aliyunSmsService.setPhoneNumber(mobile);
        aliyunSmsService.setVerificationcode(operatingName);
        try {
            if (b){
                aliyunSmsService.sendSms2("SMS_90600013");
            }
            else {
                aliyunSmsService.sendSms2("SMS_90745006");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
