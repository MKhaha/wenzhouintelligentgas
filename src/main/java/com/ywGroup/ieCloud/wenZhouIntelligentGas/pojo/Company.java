package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class Company {
    private Integer id;

    private String companyNumber;

    private String companyName;

    private Integer companyType;

    private String phone;

    private String fax;

    private String email;

    private String contactName;

    private String address;

    private String createUser;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private Integer administrativeRegion;

    private String serialNumber;

    private String description;

    public Company(Integer id, String companyNumber, String companyName, Integer companyType, String phone, String fax, String email, String contactName, String address, String createUser, Integer isDelete, Date createTime, Date updateTime, Integer administrativeRegion, String serialNumber, String description) {
        this.id = id;
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        this.companyType = companyType;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.contactName = contactName;
        this.address = address;
        this.createUser = createUser;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.administrativeRegion = administrativeRegion;
        this.serialNumber = serialNumber;
        this.description = description;
    }

    public Company() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber == null ? null : companyNumber.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}