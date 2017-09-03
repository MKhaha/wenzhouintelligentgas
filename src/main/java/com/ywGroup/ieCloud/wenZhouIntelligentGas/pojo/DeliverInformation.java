package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

public class DeliverInformation {
    private Integer id;

    private Integer locationId;

    private String name;

    private Integer company;

    private Integer station;

    private String phone;

    private String address;

    private String photoAddress;

    public DeliverInformation(Integer id, Integer locationId, String name, Integer company, Integer station, String phone, String address, String photoAddress) {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
        this.company = company;
        this.station = station;
        this.phone = phone;
        this.address = address;
        this.photoAddress = photoAddress;
    }

    public DeliverInformation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress == null ? null : photoAddress.trim();
    }
}