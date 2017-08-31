package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.activitipo;

import java.util.Date;

/**
 * Created by Administrator on 2017-8-25.
 */
public class SupervisionTaskVO {
    int id;
    String user_id;
    String details;
    String plan;
    String result;
    Date   createTime;
    String taskid;
    String taskname;
    String processinstanceid;
    Date taskcreatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getProcessinstanceid() {
        return processinstanceid;
    }

    public void setProcessinstanceid(String processinstanceid) {
        this.processinstanceid = processinstanceid;
    }

    public Date getTaskcreatetime() {
        return taskcreatetime;
    }

    public void setTaskcreatetime(Date taskcreatetime) {
        this.taskcreatetime = taskcreatetime;
    }
}
