package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GasCylinderInformation {
    private Integer id;

    private String cylinderSerialNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productionDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scrappedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chargingDate;

    private String cylinderSpecification;

    private String serialNumberPersonBelonging;

    private String namePersonBelonging;

    private String serialNumberCompanyBelonging;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nameCompanyBelonging;

    private String serialNumberAssociatedOrder;

    private Integer locationId;

    private Date createTime;

    private Date updateTime;

    public GasCylinderInformation(Integer id, String cylinderSerialNumber, Date productionDate, Date scrappedDate, Date chargingDate, String cylinderSpecification, String serialNumberPersonBelonging, String namePersonBelonging, String serialNumberCompanyBelonging, Date nameCompanyBelonging, String serialNumberAssociatedOrder, Integer locationId, Date createTime, Date updateTime) {
        this.id = id;
        this.cylinderSerialNumber = cylinderSerialNumber;
        this.productionDate = productionDate;
        this.scrappedDate = scrappedDate;
        this.chargingDate = chargingDate;
        this.cylinderSpecification = cylinderSpecification;
        this.serialNumberPersonBelonging = serialNumberPersonBelonging;
        this.namePersonBelonging = namePersonBelonging;
        this.serialNumberCompanyBelonging = serialNumberCompanyBelonging;
        this.nameCompanyBelonging = nameCompanyBelonging;
        this.serialNumberAssociatedOrder = serialNumberAssociatedOrder;
        this.locationId = locationId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public GasCylinderInformation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCylinderSerialNumber() {
        return cylinderSerialNumber;
    }

    public void setCylinderSerialNumber(String cylinderSerialNumber) {
        this.cylinderSerialNumber = cylinderSerialNumber == null ? null : cylinderSerialNumber.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getScrappedDate() {
        return scrappedDate;
    }

    public void setScrappedDate(Date scrappedDate) {
        this.scrappedDate = scrappedDate;
    }

    public Date getChargingDate() {
        return chargingDate;
    }

    public void setChargingDate(Date chargingDate) {
        this.chargingDate = chargingDate;
    }

    public String getCylinderSpecification() {
        return cylinderSpecification;
    }

    public void setCylinderSpecification(String cylinderSpecification) {
        this.cylinderSpecification = cylinderSpecification == null ? null : cylinderSpecification.trim();
    }

    public String getSerialNumberPersonBelonging() {
        return serialNumberPersonBelonging;
    }

    public void setSerialNumberPersonBelonging(String serialNumberPersonBelonging) {
        this.serialNumberPersonBelonging = serialNumberPersonBelonging == null ? null : serialNumberPersonBelonging.trim();
    }

    public String getNamePersonBelonging() {
        return namePersonBelonging;
    }

    public void setNamePersonBelonging(String namePersonBelonging) {
        this.namePersonBelonging = namePersonBelonging == null ? null : namePersonBelonging.trim();
    }

    public String getSerialNumberCompanyBelonging() {
        return serialNumberCompanyBelonging;
    }

    public void setSerialNumberCompanyBelonging(String serialNumberCompanyBelonging) {
        this.serialNumberCompanyBelonging = serialNumberCompanyBelonging == null ? null : serialNumberCompanyBelonging.trim();
    }

    public Date getNameCompanyBelonging() {
        return nameCompanyBelonging;
    }

    public void setNameCompanyBelonging(Date nameCompanyBelonging) {
        this.nameCompanyBelonging = nameCompanyBelonging;
    }

    public String getSerialNumberAssociatedOrder() {
        return serialNumberAssociatedOrder;
    }

    public void setSerialNumberAssociatedOrder(String serialNumberAssociatedOrder) {
        this.serialNumberAssociatedOrder = serialNumberAssociatedOrder == null ? null : serialNumberAssociatedOrder.trim();
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
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