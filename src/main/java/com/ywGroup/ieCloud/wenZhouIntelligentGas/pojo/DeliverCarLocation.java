package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DeliverCarLocation {
    private Integer id;

    private Integer deliverCarId;

    private Integer taskId;

    private Date timestamp;

    private BigDecimal latitude;

    private BigDecimal longitude;

    public DeliverCarLocation(Integer id, Integer deliverCarId, Integer taskId, Date timestamp, BigDecimal latitude, BigDecimal longitude) {
        this.id = id;
        this.deliverCarId = deliverCarId;
        this.taskId = taskId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public DeliverCarLocation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeliverCarId() {
        return deliverCarId;
    }

    public void setDeliverCarId(Integer deliverCarId) {
        this.deliverCarId = deliverCarId;
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