package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class GasCylinderLocation {
    private Integer id;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Date createTime;

    public GasCylinderLocation(Integer id, BigDecimal latitude, BigDecimal longitude, Date createTime) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createTime = createTime;
    }

    public GasCylinderLocation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}