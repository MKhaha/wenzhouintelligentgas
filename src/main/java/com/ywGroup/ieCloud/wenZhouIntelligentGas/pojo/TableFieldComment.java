package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

public class TableFieldComment {
    private String tableName;

    private String fieldComment;

    public TableFieldComment(String tableName, String fieldComment) {
        this.tableName = tableName;
        this.fieldComment = fieldComment;
    }

    public TableFieldComment() {
        super();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment == null ? null : fieldComment.trim();
    }
}