package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.systemSettings;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.ResourceMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.Resource;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO.ResourceTreeVO;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.systemSettings.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-8-21.
 */
@Service("iResourceService")
public class ResourceServiceImpl implements IResourceService{

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public ServerResponse<ResourceTreeVO> getResources(String resourceNumber) {
        ResourceTreeVO resourceTreeVO = this.getResourceTree(resourceNumber);
        if(resourceTreeVO!=null)
            return ServerResponse.createBySuccess("获取成功",resourceTreeVO);
        return ServerResponse.createByErrorMessage("获取失败");
    }

    public ResourceTreeVO getResourceTree(String resourceNumber){
        ResourceTreeVO resourceTreeVO = this.setVO(resourceMapper.selectByResourceNumber(resourceNumber));
        List<Resource> resources = resourceMapper.selectByParentNumber(resourceNumber);
        for (Resource resource:resources){
            ResourceTreeVO vo = getResourceTree(resource.getResourceNumber());
            resourceTreeVO.getResources().add(vo);
        }
        return resourceTreeVO;
    }

    public ResourceTreeVO setVO(Resource resource){
        ResourceTreeVO resourceTreeVO = new ResourceTreeVO();
        resourceTreeVO.setResourceNumber(resource.getResourceNumber());
        resourceTreeVO.setResourceName(resource.getResourceName());
        resourceTreeVO.setParentNumber(resource.getParentNumber());
        resourceTreeVO.setUrl(resource.getUrl());
        return resourceTreeVO;
    }
}
