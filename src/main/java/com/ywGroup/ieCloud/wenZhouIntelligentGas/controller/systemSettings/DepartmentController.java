package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Department;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IDepartmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-8-28.
 */
@Controller
@RequestMapping(value = "/systemSettings/departments/")
public class DepartmentController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    private IDepartmentService iDepartmentService;

    /**
     * 获取部门列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "get.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getDepartments(@RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                         @RequestParam(value = "departmentName",defaultValue = "")String departmentName){
        return iDepartmentService.getDepartments(pageNumber,pageSize,departmentName);
    }

    /**
     * 添加新的部门
     * @param department
     * @return
     */
    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addDepartments(Department department){
        return iDepartmentService.addDepartment(department);
    }

    /**
     * 删除部门
     * @param departmentNumber
     * @return
     */
    @RequestMapping(value = "del.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delDepartments(String departmentNumber){
        return iDepartmentService.delDepartment(departmentNumber);
    }

    /**
     * 更新部门
     * @param department
     * @return
     */
    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateDepartment(Department department){
        department.setIsDelete(0);
        return iDepartmentService.updateDepartment(department);
    }

    /**
     * 导出部门表
     * @param departmentName
     * @return
     */
    @RequestMapping(value = "ToExcel.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse toExcel(@RequestParam(value = "departmentName",defaultValue = "")String departmentName){
        return iDepartmentService.toExcel(httpSession,departmentName);
    }
}
