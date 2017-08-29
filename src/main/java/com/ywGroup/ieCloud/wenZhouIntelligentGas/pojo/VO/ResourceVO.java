package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-8-21.
 */
public class ResourceVO {

    private String resourceNumber;

    private String resourceName;

    private String parentNumber;

    private String parentName;

    private int sort;

    private String url;

    private Date createTime;

    private int resouceType;

    private String remark;

    public String getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(String resourceNumber) {
        this.resourceNumber = resourceNumber;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getResouceType() {
        return resouceType;
    }

    public void setResouceType(int resouceType) {
        this.resouceType = resouceType;
    }
}
