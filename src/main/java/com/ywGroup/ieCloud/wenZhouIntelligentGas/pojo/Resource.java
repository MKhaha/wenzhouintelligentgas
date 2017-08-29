package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class Resource {
    private Integer id;

    private String resourceNumber;

    private String resourceName;

    private String parentNumber;

    private Integer depthNumber;

    private String parentPath;

    private Integer childCount;

    private Integer sort;

    private Integer isHide;

    private Integer isDelete;

    private String url;

    private String cssName;

    private Integer resourcePosition;

    private Integer resourceType;

    private String createUser;

    private String updateUser;

    private String createIp;

    private String updateIp;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public Resource(Integer id, String resourceNumber, String resourceName, String parentNumber, Integer depthNumber, String parentPath, Integer childCount, Integer sort, Integer isHide, Integer isDelete, String url, String cssName, Integer resourcePosition, Integer resourceType, String createUser, String updateUser, String createIp, String updateIp, String remark, Date createTime, Date updateTime) {
        this.id = id;
        this.resourceNumber = resourceNumber;
        this.resourceName = resourceName;
        this.parentNumber = parentNumber;
        this.depthNumber = depthNumber;
        this.parentPath = parentPath;
        this.childCount = childCount;
        this.sort = sort;
        this.isHide = isHide;
        this.isDelete = isDelete;
        this.url = url;
        this.cssName = cssName;
        this.resourcePosition = resourcePosition;
        this.resourceType = resourceType;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createIp = createIp;
        this.updateIp = updateIp;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Resource() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(String resourceNumber) {
        this.resourceNumber = resourceNumber == null ? null : resourceNumber.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
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

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath == null ? null : parentPath.trim();
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getCssName() {
        return cssName;
    }

    public void setCssName(String cssName) {
        this.cssName = cssName == null ? null : cssName.trim();
    }

    public Integer getResourcePosition() {
        return resourcePosition;
    }

    public void setResourcePosition(Integer resourcePosition) {
        this.resourcePosition = resourcePosition;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    public String getUpdateIp() {
        return updateIp;
    }

    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp == null ? null : updateIp.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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