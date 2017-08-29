package com.ywGroup.ieCloud.wenZhouIntelligentGas.service.serviceInterface.basicInformation;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.CylinderLocation;
import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.FillingRecord;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by lenovo on 2017/8/26.
 */
public interface IFillingRecordService {
    ServerResponse queryFillingRecord(int pageNumber,int pageSize, String cylinderBarcode,String fillingWorker);
}
