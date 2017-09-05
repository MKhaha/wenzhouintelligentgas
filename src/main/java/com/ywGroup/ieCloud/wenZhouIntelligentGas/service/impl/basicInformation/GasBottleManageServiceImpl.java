package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.GasBottleManagerMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.TableFieldCommentMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.GasBottleManager;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.TableFieldComment;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IGasBottleManageService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.ExportExcel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
        System.out.println(tableFieldComment.getFieldComment());
        return ServerResponse.createBySuccess("获取成功", tableFieldComment.getFieldComment(), pageResult);
    }

    @Override
    public ServerResponse toExcelGasBottleManager(HttpSession session, String cylinderBarcode, String manufacturingUnit, String beginLandingDate, String endLandingDate, String beginLastInspectionDate, String endLastInspectionDate, String beginNextInspectionDate, String endNextInspectionDate) {
        List<GasBottleManager> gasBottleManagerList = gasBottleManagerMapper.queryGasBottleManager(cylinderBarcode,manufacturingUnit,beginLandingDate,endLandingDate,beginLastInspectionDate,endLastInspectionDate,beginNextInspectionDate,endNextInspectionDate);
        if(CollectionUtils.isEmpty(gasBottleManagerList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        String path = ExportExcel.toExcel(session,"sheet1","gas_bottle_manager","gas_bottle_manager",gasBottleManagerList);
        if(org.apache.commons.lang3.StringUtils.isBlank(path)) {
            return ServerResponse.createByErrorMessage("导出失败");
        }
        return ServerResponse.createBySuccess("导出成功",path);
    }

    @Override
    public ServerResponse insertGasBottleManager(GasBottleManager gasBottleManager) {
        int resultCount = gasBottleManagerMapper.insertSelective(gasBottleManager);
        if(resultCount > 0) {
            return ServerResponse.createBySuccessMessage("插入成功");
        }
        return ServerResponse.createByErrorMessage("插入失败");
    }

    @Override
    public ServerResponse numberOfGasBottleManagerRegions() {
        List<Map<String,String>> map = gasBottleManagerMapper.numberOfGasBottleManagerRegions();
        if(CollectionUtils.isEmpty(map)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        return ServerResponse.createBySuccess("获取成功",map);
    }

    @Override
    public ServerResponse due() {
        List<Map<String,String>> map = gasBottleManagerMapper.due();
        if(CollectionUtils.isEmpty(map)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        return ServerResponse.createBySuccess("获取成功",map);
    }

    @Override
    public ServerResponse overdue() {
        List<Map<String,String>> map = gasBottleManagerMapper.overdue();
        if(CollectionUtils.isEmpty(map)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        return ServerResponse.createBySuccess("获取成功",map);
    }

}
