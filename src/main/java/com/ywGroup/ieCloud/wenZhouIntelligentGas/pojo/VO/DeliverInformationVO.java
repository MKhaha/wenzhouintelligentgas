package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo.VO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lanmeiniu on 2017/9/2.
 */
public class DeliverInformationVO {
    //table_name :deliverInformation
    private Integer id;

    private Integer locationId;

    private String name;

    private Integer company;

    private Integer station;

    private String phone;

    private String address;

    private String photoAddress;

    //table_name: deliver_location

    private Integer taskId;

    private Date timestamp;

    private BigDecimal latitude;

    private BigDecimal longitude;

    public DeliverInformationVO() {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
        this.company = company;
        this.station = station;
        this.phone = phone;
        this.address = address;
        this.photoAddress = photoAddress;
        this.taskId = taskId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
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
