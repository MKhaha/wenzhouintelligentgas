package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.AdministratorMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.DepartmentMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Department;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.DepartmentVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IDepartmentService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-8-28.
 */
@Service("iDepartmentService")
public class DepartmentServiceImpl implements IDepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public ServerResponse<PageHelperUtil> getDepartments(Integer pageNumber, Integer pageSize,String departmentName) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Department > departments = departmentMapper.selectDepartments(departmentName);
        PageInfo pageInfo = new PageInfo(departments);
        List<DepartmentVO> departmentVOS = new ArrayList<>();
        for(Department department:departments){
            DepartmentVO departmentVO =new DepartmentVO();
            departmentVO.setId(department.getId());
            departmentVO.setDepartmentNumber(department.getDepartmentNumber());
            departmentVO.setDepartmentName(department.getDepartmentName());
            departmentVO.setParentNumber(department.getParentNumber());
            departmentVO.setParentName(departmentMapper.selectParentName(department.getParentNumber()));
            departmentVO.setIsDelete(department.getIsDelete());
            departmentVO.setCreateTime(department.getCreateTime());
            departmentVO.setUpdateTime(department.getUpdateTime());
            departmentVOS.add(departmentVO);
        }
        pageInfo.setList(departmentVOS);
        if (!departments.isEmpty()){
            return ServerResponse.createBySuccess("获取成功",PageHelperUtil.toPageHeper(pageInfo));
        }
        return ServerResponse.createByErrorMessage("获取失败");
    }

    @Override
    public ServerResponse<String> addDepartment(Department department) {
        int did = departmentMapper.selectID()+1;
        department.setDepartmentNumber("d"+did);
        department.setIsDelete(0);
        int count1 = departmentMapper.checkByNumber(department.getDepartmentNumber());
        int count = departmentMapper.insert(department);
        if (count>0&&count1==0)
            return ServerResponse.createBySuccessMessage("添加成功");
        return ServerResponse.createByErrorMessage("添加失败");
    }

    @Override
    public ServerResponse<String> delDepartment(String departmentNumber) {
        int count = administratorMapper.selectByDepartment(departmentNumber);
        int count1 = departmentMapper.selectByParentNumbet(departmentNumber);
        if (count>0||count1>0)
            return ServerResponse.createByErrorMessage("请检查此部门下成员");
        int count3 = departmentMapper.deleteByDepartmentNumber(departmentNumber);
        if(count3>0)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<String> updateDepartment(Department department) {
        int count = departmentMapper.updateByPrimaryKey(department);
        if (count>0)
            return ServerResponse.createBySuccessMessage("编辑成功");
        return ServerResponse.createByErrorMessage("编辑失败");
    }

}
