package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GasStationDirectSaleCylinderSendAndReceive {
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date directDate;

    private String processName;

    private String emptyType;

    private String cylinderBarcode;

    private String cylinderSpecifications;

    private String departureLocation;

    private String carrierVehicles;

    private String driverOrEscort;

    private String transportCompany;

    private String destination;

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

    public GasStationDirectSaleCylinderSendAndReceive(Integer id, Date directDate, String processName, String emptyType, String cylinderBarcode, String cylinderSpecifications, String departureLocation, String carrierVehicles, String driverOrEscort, String transportCompany, String destination, String operator, String manufacturingUnit, String propertyUnit, String serialNumber, String useTheRegistrationCode, String fillingMedia, Date lastInspectionDate, Date nextInspectionDate) {
        this.id = id;
        this.directDate = directDate;
        this.processName = processName;
        this.emptyType = emptyType;
        this.cylinderBarcode = cylinderBarcode;
        this.cylinderSpecifications = cylinderSpecifications;
        this.departureLocation = departureLocation;
        this.carrierVehicles = carrierVehicles;
        this.driverOrEscort = driverOrEscort;
        this.transportCompany = transportCompany;
        this.destination = destination;
        this.operator = operator;
        this.manufacturingUnit = manufacturingUnit;
        this.propertyUnit = propertyUnit;
        this.serialNumber = serialNumber;
        this.useTheRegistrationCode = useTheRegistrationCode;
        this.fillingMedia = fillingMedia;
        this.lastInspectionDate = lastInspectionDate;
        this.nextInspectionDate = nextInspectionDate;
    }

    public GasStationDirectSaleCylinderSendAndReceive() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDirectDate() {
        return directDate;
    }

    public void setDirectDate(Date directDate) {
        this.directDate = directDate;
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

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation == null ? null : departureLocation.trim();
    }

    public String getCarrierVehicles() {
        return carrierVehicles;
    }

    public void setCarrierVehicles(String carrierVehicles) {
        this.carrierVehicles = carrierVehicles == null ? null : carrierVehicles.trim();
    }

    public String getDriverOrEscort() {
        return driverOrEscort;
    }

    public void setDriverOrEscort(String driverOrEscort) {
        this.driverOrEscort = driverOrEscort == null ? null : driverOrEscort.trim();
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany == null ? null : transportCompany.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
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