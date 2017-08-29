package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasBottleManagerMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.TableFieldCommentMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasBottleManager;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.TableFieldComment;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasBottleManageService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.GetTableFieldComment;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.PageHelperUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iGasBottleManageService")
public class GasBottleManageServiceImpl implements IGasBottleManageService {

    @Autowired
    private GasBottleManagerMapper gasBottleManagerMapper;

    @Autowired
    private TableFieldCommentMapper tableFieldCommentMapper;

    @Override
    public ServerResponse queryGasBottleManager(int pageNumber, int pageSize, String cylinderBarcode, String manufacturingUnit, String beginLandingDate, String endLandingDate, String beginLastInspectionDate, String endLastInspectionDate, String beginNextInspectionDate, String endNextInspectionDate) {
        PageHelper.startPage(pageNumber, pageSize);
        System.out.println(System.currentTimeMillis());

        List<GasBottleManager> gasBottleManagerList = gasBottleManagerMapper.queryGasBottleManager(cylinderBarcode,manufacturingUnit,beginLandingDate,endLandingDate,beginLastInspectionDate,endLastInspectionDate,beginNextInspectionDate,endNextInspectionDate);
        System.out.println(System.currentTimeMillis());

        if(CollectionUtils.isEmpty(gasBottleManagerList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(gasBottleManagerList);
        pageResult.setList(gasBottleManagerList);


        System.out.println(System.currentTimeMillis());

        TableFieldComment tableFieldComment = tableFieldCommentMapper.selectByPrimaryKey("gas_bottle_manager");
        return ServerResponse.createBySuccess("获取成功", tableFieldComment.getFieldComment(), pageResult);
    }
}
