package com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.codingStandard;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by guotao on 2017/9/3.
 * com.ywGroup.ieCloud.wenZhouIntelligentGas.controller.codingStandard
 * wenzhouintelligentgas
 */
@Controller
@RequestMapping("/codingStandard/")
public class CodingStandardController {


    @RequestMapping(value = "getCompanyCodingStandard.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Map<String, String>> getCompanyCodingStandard(){
        String type = "gs";
        String administrativeRegion = "330382";
        String company = "000001";
        String crc16 = "da81";

        Map<String, String> cylinderCodingStandard = new LinkedHashMap<>();
        cylinderCodingStandard.put("example", type + administrativeRegion + company + crc16);
        cylinderCodingStandard.put("type", type);
        cylinderCodingStandard.put("administrativeRegion", administrativeRegion);
        cylinderCodingStandard.put("company", company);
        cylinderCodingStandard.put("crc16", crc16);

        return ServerResponse.createBySuccess("获取成功", cylinderCodingStandard);
    }


    @RequestMapping(value = "getStationCodingStandard.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Map<String, String>> getStationCodingStandard(){
        String type = "qz";
        String administrativeRegion = "330382";
        String company = "000005";
        String station = "000001";
        String crc16 = "74c0";

        Map<String, String> cylinderCodingStandard = new LinkedHashMap<>();
        cylinderCodingStandard.put("example", type + administrativeRegion + company + station + crc16);
        cylinderCodingStandard.put("type", type);
        cylinderCodingStandard.put("administrativeRegion", administrativeRegion);
        cylinderCodingStandard.put("company", company);
        cylinderCodingStandard.put("station", station);
        cylinderCodingStandard.put("crc16", crc16);

        return ServerResponse.createBySuccess("获取成功", cylinderCodingStandard);
    }



    @RequestMapping(value = "getCylinderCodingStandard.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Map<String, String>> getCylinderCodingStandard(){
        String type = "qp";
        String administrativeRegion = "330382";
        String company = "000005";
        String station = "000001";
        String cylinder = "9053000001";
        String crc16 = "be01";

        Map<String, String> cylinderCodingStandard = new LinkedHashMap<>();
        cylinderCodingStandard.put("example", type + administrativeRegion + company + station + cylinder + crc16);
        cylinderCodingStandard.put("type", type);
        cylinderCodingStandard.put("administrativeRegion", administrativeRegion);
        cylinderCodingStandard.put("company", company);
        cylinderCodingStandard.put("station", station);
        cylinderCodingStandard.put("cylinder", cylinder);
        cylinderCodingStandard.put("crc16", crc16);

        return ServerResponse.createBySuccess("获取成功", cylinderCodingStandard);
    }

}
