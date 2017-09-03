package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lanmeiniu on 2017/9/2.
 */
public class DeliverCarVO {

    private Integer id;

    private Integer locationId;

    private String deliverCarCode;

    private String carLicensePlate;

    private Integer company;

    private Integer station;

    private Integer responsible;

    private String phoneResponsible;

    private Integer taskId;

    private Date timestamp;

    private BigDecimal latitude;

    private BigDecimal longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getDeliverCarCode() {
        return deliverCarCode;
    }

    public void setDeliverCarCode(String deliverCarCode) {
        this.deliverCarCode = deliverCarCode;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getStation() {
        return station;
    }

    public void setStation(Integer station) {
        this.station = station;
    }

    public Integer getResponsible() {
        return responsible;
    }

    public void setResponsible(Integer responsible) {
        this.responsible = responsible;
    }

    public String getPhoneResponsible() {
        return phoneResponsible;
    }

    public void setPhoneResponsible(String phoneResponsible) {
        this.phoneResponsible = phoneResponsible;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
