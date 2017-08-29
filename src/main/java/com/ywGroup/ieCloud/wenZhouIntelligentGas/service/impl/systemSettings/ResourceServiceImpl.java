package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.ResourceMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.RoleResourceRelationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Resource;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.RoleResourceRelation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.ResourceVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.ResourceVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IResourceService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-8-21.
 */
@Service("iResourceService")
public class ResourceServiceImpl implements IResourceService{

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;


    @Override
    public ServerResponse<PageHelperUtil> getResources(Integer pageNumber,Integer pageSize,String resourceName,String remark) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Resource> r1 = resourceMapper.selectByResourceNumber(resourceName,remark);
        List<ResourceVO> resources = this.getResources(r1);
        PageInfo pageInfo = new PageInfo(r1);
        pageInfo.setList(resources);
        if(resources!=null)
            return ServerResponse.createBySuccess("获取成功",PageHelperUtil.toPageHeper(pageInfo));
        return ServerResponse.createByErrorMessage("获取失败");
    }

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

    public List<ResourceVO> getResources(List<Resource> r1){
        List<ResourceVO> resourceVO1 = new ArrayList<>();
        for (Resource resource:r1) {
            ResourceVO resourceVO = new ResourceVO();
            resourceVO.setCreateTime(resource.getCreateTime());
            resourceVO.setRemark(resource.getRemark());
            resourceVO.setResouceType(resource.getResourceType());
            resourceVO.setResourceNumber(resource.getResourceNumber());
            resourceVO.setResourceName(resource.getResourceName());
            resourceVO.setParentNumber(resource.getParentNumber());
            resourceVO.setUrl(resource.getUrl());
            resourceVO.setSort(resource.getSort());
            resourceVO.setParentName(resourceMapper.selectParentName(resource.getParentNumber()));
            resourceVO1.add(resourceVO);
        }
        return resourceVO1;
    }
}
