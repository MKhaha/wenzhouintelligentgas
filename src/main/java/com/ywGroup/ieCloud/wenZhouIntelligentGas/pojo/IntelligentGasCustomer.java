package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class IntelligentGasCustomer {
    private Integer id;

    private String customerNumber;

    private String customerName;

    private String phone;

    private String email;

    private String fax;

    private String address;

    private Integer customerType;

    private Integer isDelete;

    private String createUser;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public IntelligentGasCustomer(Integer id, String customerNumber, String customerName, String phone, String email, String fax, String address, Integer customerType, Integer isDelete, String createUser, String remark, Date createTime, Date updateTime) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.fax = fax;
        this.address = address;
        this.customerType = customerType;
        this.isDelete = isDelete;
        this.createUser = createUser;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public IntelligentGasCustomer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber == null ? null : customerNumber.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
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