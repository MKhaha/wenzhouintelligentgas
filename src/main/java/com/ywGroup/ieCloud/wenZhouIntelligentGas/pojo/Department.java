package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class Department {
    private Integer id;

    private String departmentNumber;

    private String departmentName;

    private Integer childCount;

    private String parentNumber;

    private Integer depthNumber;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    public Department(Integer id, String departmentNumber, String departmentName, Integer childCount, String parentNumber, Integer depthNumber, Integer isDelete, Date createTime, Date updateTime) {
        this.id = id;
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.childCount = childCount;
        this.parentNumber = parentNumber;
        this.depthNumber = depthNumber;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Department() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber == null ? null : departmentNumber.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber == null ? null : parentNumber.trim();
    }

    public Integer getDepthNumber() {
        return depthNumber;
    }

    public void setDepthNumber(Integer depthNumber) {
        this.depthNumber = depthNumber;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}