package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

public class DeliverCar {
    private Integer id;

    private String deliverCarCode;

    private String carLicensePlate;

    private Integer company;

    private Integer station;

    private Integer responsible;

    private String phoneResponsible;

    public DeliverCar(Integer id, String deliverCarCode, String carLicensePlate, Integer company, Integer station, Integer responsible, String phoneResponsible) {
        this.id = id;
        this.deliverCarCode = deliverCarCode;
        this.carLicensePlate = carLicensePlate;
        this.company = company;
        this.station = station;
        this.responsible = responsible;
        this.phoneResponsible = phoneResponsible;
    }

    public DeliverCar() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliverCarCode() {
        return deliverCarCode;
    }

    public void setDeliverCarCode(String deliverCarCode) {
        this.deliverCarCode = deliverCarCode == null ? null : deliverCarCode.trim();
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate == null ? null : carLicensePlate.trim();
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

    public Integer getResponsible() {
        return responsible;
    }

    public void setResponsible(Integer responsible) {
        this.responsible = responsible;
    }

    public String getPhoneResponsible() {
        return phoneResponsible;
    }

    public void setPhoneResponsible(String phoneResponsible) {
        this.phoneResponsible = phoneResponsible == null ? null : phoneResponsible.trim();
    }
}