package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo;

import java.util.Date;

public class Supervision {
    private Integer id;

    private String processInstanceId;

    private Integer userId;

    private String details;

    private String plan;

    private String result;

    private Date createTime;

    public Supervision(Integer id, String processInstanceId, Integer userId, String details, String plan, String result,  Date createTime) {
        this.id = id;
        this.processInstanceId = processInstanceId;
        this.userId = userId;
        this.details = details;
        this.plan = plan;
        this.result = result;
        this.createTime = createTime;
    }

    public Supervision() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan == null ? null : plan.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}