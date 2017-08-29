package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.Const;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.AdministratorMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleResourceRelationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Role;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.AdministatorVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IRoleService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017-8-21.
 */
@Service("iRoleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public ServerResponse<String> addRole(Role role) {
        int roleNumber = roleMapper.selectBylastID()+1;
        role.setRoleNumber("r"+roleNumber);
        int count = roleMapper.checkByNumber(role.getRoleNumber());
        int count2 = roleMapper.insert(role);
        if(count2>0&&count==0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }

    @Override
    public ServerResponse<String> delRole(String roleNumber) {
        int count = administratorMapper.checkByRoleNumber(roleNumber);
        if(count>0){
            return ServerResponse.createByErrorMessage("请检查此角色的用户!");
        }
        int count2 = roleMapper.deleteByRoleNumber(roleNumber);
        int count3 = roleResourceRelationMapper.deleteByRoleNumber(roleNumber);
        if(count2>0 ){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<PageHelperUtil> getRoles(HttpSession session,int pageNumber,int pageSize,String roleName,String remark) {
        //AdministatorVO administatorVO = (AdministatorVO) session.getAttribute(Const.CURRENT_USER);
        PageHelper.startPage(pageNumber,pageSize);
        List<Role> roles = roleMapper.getRoles("1",roleName,remark);//administatorVO.getCompany());
        PageInfo pageResult = new PageInfo(roles);
        pageResult.setList(roles);
        if (!roles.isEmpty())
            return ServerResponse.createBySuccess("获取成功", PageHelperUtil.toPageHeper(pageResult));
        return ServerResponse.createByErrorMessage("获取失败");
    }

    @Override
    public ServerResponse<String> setRole(Integer userid, String roleNumber) {
        int count = administratorMapper.setRole(userid, roleNumber);
        if (count > 0)
            return ServerResponse.createBySuccessMessage("设置成功");
        return ServerResponse.createByErrorMessage("设置失败");
    }

    @Override
    public ServerResponse<String> updateRole(Role role) {
        int count = roleMapper.updateByPrimaryKeySelective(role);
        if(count>0)
            return ServerResponse.createBySuccessMessage("更新成功");
        return ServerResponse.createByErrorMessage("更新失败");
    }
}
