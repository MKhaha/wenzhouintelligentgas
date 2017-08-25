package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class IntelligentGasCustomerAddress {
    private Integer id;

    private String serialNumber;

    private String customerNumber;

    private String contact;

    private String phone;

    private String address;

    private Integer isDelete;

    private String createUser;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public IntelligentGasCustomerAddress(Integer id, String serialNumber, String customerNumber, String contact, String phone, String address, Integer isDelete, String createUser, String remark, Date createTime, Date updateTime) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.customerNumber = customerNumber;
        this.contact = contact;
        this.phone = phone;
        this.address = address;
        this.isDelete = isDelete;
        this.createUser = createUser;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public IntelligentGasCustomerAddress() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber == null ? null : customerNumber.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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