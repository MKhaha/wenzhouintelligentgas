package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasStationMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasStation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/9/4.
 */
@Service("iGasStationService")
public class GasStationServiceImpl  implements IGasStationService{

    @Autowired
    private GasStationMapper gasStationMapper;
    @Override
    public ServerResponse updateGasStation(GasStation gasStation) {
        int resultCount = gasStationMapper.updateByPrimaryKey(gasStation);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse selectGasStationAll(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<GasStation> gasStationList = gasStationMapper.selectAll();
        if(org.apache.commons.collections.CollectionUtils.isEmpty(gasStationList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(gasStationList);
        pageResult.setList(gasStationList);
        return ServerResponse.createBySuccess("获取成功",pageResult);
    }

    @Override
    public ServerResponse deleteGasStationByCode(String code) {
        int resultCount = gasStationMapper.deleteByCode(code);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createBySuccessMessage("删除失败");
    }

    @Override
    public ServerResponse insertGasStation(GasStation gasStation) {
        int resultCount  = gasStationMapper.insertSelective(gasStation);
        if(resultCount > 0 ){
            return ServerResponse.createBySuccessMessage("插入成功");
        }
        return ServerResponse.createByErrorMessage("插入失败");
    }

    @Override
    public ServerResponse selectGasStationByCode(String code) {
        GasStation gasStation = gasStationMapper.selectByCode(code);
        if(null != gasStation) {
            return ServerResponse.createBySuccess("获取成功",gasStation);
        }
        return ServerResponse.createByErrorMessage("获取失败");
    }
}
