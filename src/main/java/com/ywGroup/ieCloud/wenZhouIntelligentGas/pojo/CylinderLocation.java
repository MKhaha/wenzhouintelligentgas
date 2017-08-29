package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CylinderLocation {
    private Integer id;

    private Date timestamp;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String cylinderSerialNumber;

    public CylinderLocation(Integer id, Date timestamp, BigDecimal latitude, BigDecimal longitude, String cylinderSerialNumber) {
        this.id = id;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cylinderSerialNumber = cylinderSerialNumber;
    }

    public CylinderLocation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCylinderSerialNumber() {
        return cylinderSerialNumber;
    }

    public void setCylinderSerialNumber(String cylinderSerialNumber) {
        this.cylinderSerialNumber = cylinderSerialNumber == null ? null : cylinderSerialNumber.trim();
    }
}