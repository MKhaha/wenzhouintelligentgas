package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-8-21.
 */
public class ResourceTreeVO {

    private String resourceNumber;

    private String resourceName;

    private String parentNumber;

    private String url;

    private List resources = new ArrayList();

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

    public List getResources() {
        return resources;
    }

    public void setResources(List resources) {
        this.resources = resources;
    }
}
