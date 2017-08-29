package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleResourceRelationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.RoleResourceRelation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IRoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-8-21.
 */
@Service("iRoleResourceService")
public class RoleResourceImpl implements IRoleResourceService {

    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;

    @Override
    public ServerResponse setResources(String[] resources, String roleNumber) {
        int count = roleResourceRelationMapper.deleteByRoleNumber(roleNumber);
        List<RoleResourceRelation> relations = new ArrayList<>();
        for(String s:resources){
            RoleResourceRelation relation = new RoleResourceRelation();
            relation.setRoleNumber(roleNumber);
            relation.setResourceNumber(s);
            relations.add(relation);
        }
        int count2 = roleResourceRelationMapper.insertRelations(relations);
        if(count2>0){
            return ServerResponse.createBySuccessMessage("分配成功");
        }
        return ServerResponse.createByErrorMessage("分配失败");
    }
}
