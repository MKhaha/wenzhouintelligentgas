package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.EventTendency;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventTendencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EventTendency record);

    int insertSelective(EventTendency record);

    EventTendency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventTendency record);

    int updateByPrimaryKey(EventTendency record);

    List<EventTendency> selectAll();

    List<EventTendency> queryEventTendencyByAdministrativeRegions(@Param("administrativeRegions") String administrativeRegions);
}