package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.impl.basicInformation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.dao.FillingRecordMapper;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.FillingRecord;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation.IFillingRecordService;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.util.ExportExcel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
@Service("iFillingRecordService")
public class FillingRecordServiceImpl implements IFillingRecordService {

    @Autowired
    private FillingRecordMapper fillingRecordMapper;

    @Override
    public ServerResponse queryFillingRecord(int pageNumber, int pageSize, String cylinderBarcode, String fillingWorker) {
        PageHelper.startPage(pageNumber, pageSize);
        List<FillingRecord> fillingRecordList = fillingRecordMapper.queryFillingRecord(cylinderBarcode,fillingWorker);
        if(CollectionUtils.isEmpty(fillingRecordList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        PageInfo pageResult = new PageInfo(fillingRecordList);
        pageResult.setList(fillingRecordList);
        return ServerResponse.createBySuccess("获取成功", pageResult);
    }

    @Override
    public ServerResponse toExcelFillingRecord(HttpSession session, String cylinderBarcode, String fillingWorker) {
        List<FillingRecord> fillingRecordList = fillingRecordMapper.queryFillingRecord(cylinderBarcode,fillingWorker);
        if(org.apache.commons.collections.CollectionUtils.isEmpty(fillingRecordList)) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
        String path = ExportExcel.toExcel(session,"sheet1","filling_record","filling_record",fillingRecordList);
        if(org.apache.commons.lang3.StringUtils.isBlank(path)) {
            return ServerResponse.createByErrorMessage("导出失败");
        }
        return ServerResponse.createBySuccess("导出成功",path);
    }
}
