package com.ywGroup.ieCloud.wenZhouIntelligentGas.dao;

import com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.TableFieldComment;

public interface TableFieldCommentMapper {
    int deleteByPrimaryKey(String tableName);

    int insert(TableFieldComment record);

    int insertSelective(TableFieldComment record);

    TableFieldComment selectByPrimaryKey(String tableName);

    int updateByPrimaryKeySelective(TableFieldComment record);

    int updateByPrimaryKey(TableFieldComment record);
}