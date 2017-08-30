//
//package com.ywGroup.ieCloud.wenZhouIntelligentGas.aop;
//
///**
// * Created by lanmeiniu on 2017/8/26.
// */
//
//import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
//import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Log;
//import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
//import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.ILogService;
//import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.DateUtil;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.net.UnknownHostException;
//
///**
// * Created by Administrator on 2017-7-26.
// */
//
//@Component
//@Aspect
//public class LogAspect{
//    @Autowired
//    private ILogService iLogService;
//
//    Logger logger = LoggerFactory.getLogger(LogAspect.class);
//
//    @Pointcut("execution(* com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.*.*Controller.*(..))")
//    public void pointcut(){}
//
//
//    @Before("pointcut()")
//    public void BeforeMethod(JoinPoint point){
//        String methodName = point.getSignature().getName();//调用的接口名称
//        Object[] objects = point.getArgs();
//        String args = "";
//        for (Object o :objects){
//            args  += o.toString()+";   ";
//        }
//        System.out.println("进入方法:"+ methodName +"  传入参数为:"+ args);
//    }
//
//    @AfterReturning(pointcut = "pointcut()")
//    public void AfterReturningMethod(JoinPoint point) throws UnknownHostException {
//        String methodName = point.getSignature().getName();//调用的接口名称
//        Object[] objects = point.getArgs();
//        String args = "";
//        for (Object o :objects){
//            args  += o.toString()+";   ";
//        }
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        //得到的是ip地址192.168.1.8
//        String StringIp = request.getRemoteAddr();
//
//        //读取session中的用户
//        AdministatorVO user = (AdministatorVO) session.getAttribute(Const.CURRENT_USER);
//        System.out.println("user.getUserName = " + user.getUserName() );
//        System.out.println("methodName = " + methodName );
//        System.out.println("ip = " + StringIp );
//        System.out.println("setAccessTime = " + DateUtil.getCurrentDate() );
//
//        //获取请求ip
//
//        Log log = new Log();
//        log.setUser(user.getUserName());
//        log.setMethodName(methodName);
//        log.setRequestIp(StringIp);
//        log.setAccessTime(DateUtil.getCurrentDate());
//
//        iLogService.insertLogToDatabase(log);
//
//    }
//
//    @AfterThrowing(pointcut = "pointcut()",throwing = "ex")
//    public void AfterThrowingMethod(JoinPoint point,Exception ex){
//        String methodName = point.getSignature().getName();
//        logger.error("调用的方法:"+ methodName +"  抛出"+ ex +"异常");
//        System.out.println("methodName = [" + methodName + "], ex = [" + ex + "]");
//
//    }
//
//}
