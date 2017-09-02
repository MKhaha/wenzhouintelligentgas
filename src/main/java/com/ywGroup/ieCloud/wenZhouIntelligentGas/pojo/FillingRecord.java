package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class FillingRecord {
    private Long id;

    private String machineNumber;

    private String fillingNumber;

    private String cylinderBarcode;

    private String fillingMedia;

    private String cylinderModel;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startingTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Float tare;

    private Float beforeTheWeight;

    private Float chargeActualValue;

    private Float setActualValue;

    private Float actualFillingVolume;

    private Float spillage;

    private String ownNumber;

    private String manufacturingUnit;

    private String propertyUnit;

    private String serialNumber;

    private String fillingWorker;

    public FillingRecord(Long id, String machineNumber, String fillingNumber, String cylinderBarcode, String fillingMedia, String cylinderModel, Date startingTime, Date endTime, Float tare, Float beforeTheWeight, Float chargeActualValue, Float setActualValue, Float actualFillingVolume, Float spillage, String ownNumber, String manufacturingUnit, String propertyUnit, String serialNumber, String fillingWorker) {
        this.id = id;
        this.machineNumber = machineNumber;
        this.fillingNumber = fillingNumber;
        this.cylinderBarcode = cylinderBarcode;
        this.fillingMedia = fillingMedia;
        this.cylinderModel = cylinderModel;
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.tare = tare;
        this.beforeTheWeight = beforeTheWeight;
        this.chargeActualValue = chargeActualValue;
        this.setActualValue = setActualValue;
        this.actualFillingVolume = actualFillingVolume;
        this.spillage = spillage;
        this.ownNumber = ownNumber;
        this.manufacturingUnit = manufacturingUnit;
        this.propertyUnit = propertyUnit;
        this.serialNumber = serialNumber;
        this.fillingWorker = fillingWorker;
    }

    public FillingRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(String machineNumber) {
        this.machineNumber = machineNumber == null ? null : machineNumber.trim();
    }

    public String getFillingNumber() {
        return fillingNumber;
    }

    public void setFillingNumber(String fillingNumber) {
        this.fillingNumber = fillingNumber == null ? null : fillingNumber.trim();
    }

    public String getCylinderBarcode() {
        return cylinderBarcode;
    }

    public void setCylinderBarcode(String cylinderBarcode) {
        this.cylinderBarcode = cylinderBarcode == null ? null : cylinderBarcode.trim();
    }

    public String getFillingMedia() {
        return fillingMedia;
    }

    public void setFillingMedia(String fillingMedia) {
        this.fillingMedia = fillingMedia == null ? null : fillingMedia.trim();
    }

    public String getCylinderModel() {
        return cylinderModel;
    }

    public void setCylinderModel(String cylinderModel) {
        this.cylinderModel = cylinderModel == null ? null : cylinderModel.trim();
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getTare() {
        return tare;
    }

    public void setTare(Float tare) {
        this.tare = tare;
    }

    public Float getBeforeTheWeight() {
        return beforeTheWeight;
    }

    public void setBeforeTheWeight(Float beforeTheWeight) {
        this.beforeTheWeight = beforeTheWeight;
    }

    public Float getChargeActualValue() {
        return chargeActualValue;
    }

    public void setChargeActualValue(Float chargeActualValue) {
        this.chargeActualValue = chargeActualValue;
    }

    public Float getSetActualValue() {
        return setActualValue;
    }

    public void setSetActualValue(Float setActualValue) {
        this.setActualValue = setActualValue;
    }

    public Float getActualFillingVolume() {
        return actualFillingVolume;
    }

    public void setActualFillingVolume(Float actualFillingVolume) {
        this.actualFillingVolume = actualFillingVolume;
    }

    public Float getSpillage() {
        return spillage;
    }

    public void setSpillage(Float spillage) {
        this.spillage = spillage;
    }

    public String getOwnNumber() {
        return ownNumber;
    }

    public void setOwnNumber(String ownNumber) {
        this.ownNumber = ownNumber == null ? null : ownNumber.trim();
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

    public String getFillingWorker() {
        return fillingWorker;
    }

    public void setFillingWorker(String fillingWorker) {
        this.fillingWorker = fillingWorker == null ? null : fillingWorker.trim();
    }
}
