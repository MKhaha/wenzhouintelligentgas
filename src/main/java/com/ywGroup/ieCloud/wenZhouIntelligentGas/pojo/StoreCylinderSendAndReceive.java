package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StoreCylinderSendAndReceive {
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date storeDate;

    private String processName;

    private String emptyType;

    private String cylinderBarcode;

    private String cylinderSpecifications;

    private String unit;

    private String carNumber;

    private String operator;

    private String manufacturingUnit;

    private String propertyUnit;

    private String serialNumber;

    private String useTheRegistrationCode;

    private String fillingMedia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastInspectionDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextInspectionDate;

    public StoreCylinderSendAndReceive(Integer id, Date storeDate, String processName, String emptyType, String cylinderBarcode, String cylinderSpecifications, String unit, String carNumber, String operator, String manufacturingUnit, String propertyUnit, String serialNumber, String useTheRegistrationCode, String fillingMedia, Date lastInspectionDate, Date nextInspectionDate) {
        this.id = id;
        this.storeDate = storeDate;
        this.processName = processName;
        this.emptyType = emptyType;
        this.cylinderBarcode = cylinderBarcode;
        this.cylinderSpecifications = cylinderSpecifications;
        this.unit = unit;
        this.carNumber = carNumber;
        this.operator = operator;
        this.manufacturingUnit = manufacturingUnit;
        this.propertyUnit = propertyUnit;
        this.serialNumber = serialNumber;
        this.useTheRegistrationCode = useTheRegistrationCode;
        this.fillingMedia = fillingMedia;
        this.lastInspectionDate = lastInspectionDate;
        this.nextInspectionDate = nextInspectionDate;
    }

    public StoreCylinderSendAndReceive() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(Date storeDate) {
        this.storeDate = storeDate;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public String getEmptyType() {
        return emptyType;
    }

    public void setEmptyType(String emptyType) {
        this.emptyType = emptyType == null ? null : emptyType.trim();
    }

    public String getCylinderBarcode() {
        return cylinderBarcode;
    }

    public void setCylinderBarcode(String cylinderBarcode) {
        this.cylinderBarcode = cylinderBarcode == null ? null : cylinderBarcode.trim();
    }

    public String getCylinderSpecifications() {
        return cylinderSpecifications;
    }

    public void setCylinderSpecifications(String cylinderSpecifications) {
        this.cylinderSpecifications = cylinderSpecifications == null ? null : cylinderSpecifications.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getManufacturingUnit() {
        return manufacturingUnit;
    }

    public void setManufacturingUnit(String manufacturingUnit) {
        this.manufacturingUnit = manufacturingUnit == null ? null : manufacturingUnit.trim();
    }

    public String getPropertyUnit() {
        return propertyUnit;
    }

    public void setPropertyUnit(String propertyUnit) {
        this.propertyUnit = propertyUnit == null ? null : propertyUnit.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getUseTheRegistrationCode() {
        return useTheRegistrationCode;
    }

    public void setUseTheRegistrationCode(String useTheRegistrationCode) {
        this.useTheRegistrationCode = useTheRegistrationCode == null ? null : useTheRegistrationCode.trim();
    }

    public String getFillingMedia() {
        return fillingMedia;
    }

    public void setFillingMedia(String fillingMedia) {
        this.fillingMedia = fillingMedia == null ? null : fillingMedia.trim();
    }

    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(Date lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    public Date getNextInspectionDate() {
        return nextInspectionDate;
    }

    public void setNextInspectionDate(Date nextInspectionDate) {
        this.nextInspectionDate = nextInspectionDate;
    }
}