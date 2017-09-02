package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DeliverLocation {
    private Integer id;

    private Integer deliverId;

    private Integer taskId;

    private Date timestamp;

    private BigDecimal latitude;

    private BigDecimal longitude;

    public DeliverLocation(Integer id, Integer deliverId, Integer taskId, Date timestamp, BigDecimal latitude, BigDecimal longitude) {
        this.id = id;
        this.deliverId = deliverId;
        this.taskId = taskId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public DeliverLocation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Integer deliverId) {
        this.deliverId = deliverId;
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