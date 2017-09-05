package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO;

import java.util.Date;

/**
 * Created by Administrator on 2017-9-4.
 */
public class ProcessVO {
    private Integer id;

    private String name;

    private String describe;

    private Integer founderId;

    private String founder;

    private Date creatTime;

    private String[] parties;

    private String details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getFounderId() {
        return founderId;
    }

    public void setFounderId(Integer founderId) {
        this.founderId = founderId;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String[] getParties() {
        return parties;
    }

    public void setParties(String[] parties) {
        this.parties = parties;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
