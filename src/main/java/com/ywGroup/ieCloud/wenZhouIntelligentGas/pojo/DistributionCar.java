package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class DistributionCar {
    private Integer id;

    private String carSerialNumber;

    private String detail;

    private Integer responsibleId;

    private String responsibleName;

    private Integer gpsId;

    private Date createTime;

    private Date updateTime;

    public DistributionCar(Integer id, String carSerialNumber, String detail, Integer responsibleId, String responsibleName, Integer gpsId, Date createTime, Date updateTime) {
        this.id = id;
        this.carSerialNumber = carSerialNumber;
        this.detail = detail;
        this.responsibleId = responsibleId;
        this.responsibleName = responsibleName;
        this.gpsId = gpsId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public DistributionCar() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarSerialNumber() {
        return carSerialNumber;
    }

    public void setCarSerialNumber(String carSerialNumber) {
        this.carSerialNumber = carSerialNumber == null ? null : carSerialNumber.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(Integer responsibleId) {
        this.responsibleId = responsibleId;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName == null ? null : responsibleName.trim();
    }

    public Integer getGpsId() {
        return gpsId;
    }

    public void setGpsId(Integer gpsId) {
        this.gpsId = gpsId;
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