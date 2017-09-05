package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

public class GasStation {
    private Integer id;

    private String code;

    private String parentCompany;

    private String name;

    private String address;

    private Integer administrativeRegion;

    private String serialNumber;

    public GasStation(Integer id, String code, String parentCompany, String name, String address, Integer administrativeRegion, String serialNumber) {
        this.id = id;
        this.code = code;
        this.parentCompany = parentCompany;
        this.name = name;
        this.address = address;
        this.administrativeRegion = administrativeRegion;
        this.serialNumber = serialNumber;
    }

    public GasStation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany == null ? null : parentCompany.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAdministrativeRegion() {
        return administrativeRegion;
    }

    public void setAdministrativeRegion(Integer administrativeRegion) {
        this.administrativeRegion = administrativeRegion;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }
}