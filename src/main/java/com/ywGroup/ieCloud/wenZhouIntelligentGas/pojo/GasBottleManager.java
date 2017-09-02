package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class GasBottleManager {
    private Long id;

    private String ownNumber;

    private String cylinderBarcode;

    private String propertyRights;

    private String propertyUnit;

    private String manufacturingUnit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date landingDate;

    private String useTheRegistrationCode;

    private String serialNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearOfManufacture;

    private String fillingMedia;

    private String cylinderModel;

    private String equipmentVariety;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastInspectionDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextInspectionDate;

    private String cylinderStatus;

    private String inspectionNumber;

    private Float originalWeight;

    private Float volume;

    private Float designWallThickness;

    private Float pressureTestPressure;

    private Float nominalOperatingPressure;

    private Integer administrativeRegion;

    public GasBottleManager(Long id, String ownNumber, String cylinderBarcode, String propertyRights, String propertyUnit, String manufacturingUnit, Date landingDate, String useTheRegistrationCode, String serialNumber, Date yearOfManufacture, String fillingMedia, String cylinderModel, String equipmentVariety, Date lastInspectionDate, Date nextInspectionDate, String cylinderStatus, String inspectionNumber, Float originalWeight, Float volume, Float designWallThickness, Float pressureTestPressure, Float nominalOperatingPressure, Integer administrativeRegion) {
        this.id = id;
        this.ownNumber = ownNumber;
        this.cylinderBarcode = cylinderBarcode;
        this.propertyRights = propertyRights;
        this.propertyUnit = propertyUnit;
        this.manufacturingUnit = manufacturingUnit;
        this.landingDate = landingDate;
        this.useTheRegistrationCode = useTheRegistrationCode;
        this.serialNumber = serialNumber;
        this.yearOfManufacture = yearOfManufacture;
        this.fillingMedia = fillingMedia;
        this.cylinderModel = cylinderModel;
        this.equipmentVariety = equipmentVariety;
        this.lastInspectionDate = lastInspectionDate;
        this.nextInspectionDate = nextInspectionDate;
        this.cylinderStatus = cylinderStatus;
        this.inspectionNumber = inspectionNumber;
        this.originalWeight = originalWeight;
        this.volume = volume;
        this.designWallThickness = designWallThickness;
        this.pressureTestPressure = pressureTestPressure;
        this.nominalOperatingPressure = nominalOperatingPressure;
        this.administrativeRegion = administrativeRegion;
    }

    public GasBottleManager() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnNumber() {
        return ownNumber;
    }

    public void setOwnNumber(String ownNumber) {
        this.ownNumber = ownNumber == null ? null : ownNumber.trim();
    }

    public String getCylinderBarcode() {
        return cylinderBarcode;
    }

    public void setCylinderBarcode(String cylinderBarcode) {
        this.cylinderBarcode = cylinderBarcode == null ? null : cylinderBarcode.trim();
    }

    public String getPropertyRights() {
        return propertyRights;
    }

    public void setPropertyRights(String propertyRights) {
        this.propertyRights = propertyRights == null ? null : propertyRights.trim();
    }

    public String getPropertyUnit() {
        return propertyUnit;
    }

    public void setPropertyUnit(String propertyUnit) {
        this.propertyUnit = propertyUnit == null ? null : propertyUnit.trim();
    }

    public String getManufacturingUnit() {
        return manufacturingUnit;
    }

    public void setManufacturingUnit(String manufacturingUnit) {
        this.manufacturingUnit = manufacturingUnit == null ? null : manufacturingUnit.trim();
    }

    public Date getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(Date landingDate) {
        this.landingDate = landingDate;
    }

    public String getUseTheRegistrationCode() {
        return useTheRegistrationCode;
    }

    public void setUseTheRegistrationCode(String useTheRegistrationCode) {
        this.useTheRegistrationCode = useTheRegistrationCode == null ? null : useTheRegistrationCode.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
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

    public String getEquipmentVariety() {
        return equipmentVariety;
    }

    public void setEquipmentVariety(String equipmentVariety) {
        this.equipmentVariety = equipmentVariety == null ? null : equipmentVariety.trim();
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

    public String getCylinderStatus() {
        return cylinderStatus;
    }

    public void setCylinderStatus(String cylinderStatus) {
        this.cylinderStatus = cylinderStatus == null ? null : cylinderStatus.trim();
    }

    public String getInspectionNumber() {
        return inspectionNumber;
    }

    public void setInspectionNumber(String inspectionNumber) {
        this.inspectionNumber = inspectionNumber == null ? null : inspectionNumber.trim();
    }

    public Float getOriginalWeight() {
        return originalWeight;
    }

    public void setOriginalWeight(Float originalWeight) {
        this.originalWeight = originalWeight;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getDesignWallThickness() {
        return designWallThickness;
    }

    public void setDesignWallThickness(Float designWallThickness) {
        this.designWallThickness = designWallThickness;
    }

    public Float getPressureTestPressure() {
        return pressureTestPressure;
    }

    public void setPressureTestPressure(Float pressureTestPressure) {
        this.pressureTestPressure = pressureTestPressure;
    }

    public Float getNominalOperatingPressure() {
        return nominalOperatingPressure;
    }

    public void setNominalOperatingPressure(Float nominalOperatingPressure) {
        this.nominalOperatingPressure = nominalOperatingPressure;
    }

    public Integer getAdministrativeRegion() {
        return administrativeRegion;
    }

    public void setAdministrativeRegion(Integer administrativeRegion) {
        this.administrativeRegion = administrativeRegion;
    }
}
