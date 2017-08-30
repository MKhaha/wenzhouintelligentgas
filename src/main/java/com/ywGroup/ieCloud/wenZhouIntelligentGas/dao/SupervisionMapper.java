package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo.Supervision;
import org.apache.ibatis.annotations.Param;

public interface SupervisionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supervision record);

    int insertSelective(Supervision record);

    Supervision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supervision record);

    int updateByPrimaryKey(Supervision record);

    int updatePlanByProsessid(@Param("processid") String processid , @Param("plan") String plan);

    int updateResultByProsessid(@Param("processid") String processid ,@Param("result") String result);

    int selectUseridByProsessid(String processid);
}