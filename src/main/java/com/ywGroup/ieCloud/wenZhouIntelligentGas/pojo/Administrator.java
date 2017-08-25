package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class Administrator {
    private Integer id;

    private String userName;

    private String password;

    private String userCode;

    private String realName;

    private String email;

    private String mobile;

    private String phone;

    private String createIp;

    private String createUser;

    private Integer loginCount;

    private String picture;

    private Integer isDelete;

    private Integer status;

    private String department;

    private String parentCode;

    private String roleNumber;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public Administrator(Integer id, String userName, String password, String userCode, String realName, String email, String mobile, String phone, String createIp, String createUser, Integer loginCount, String picture, Integer isDelete, Integer status, String department, String parentCode, String roleNumber, String remark, Date createTime, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userCode = userCode;
        this.realName = realName;
        this.email = email;
        this.mobile = mobile;
        this.phone = phone;
        this.createIp = createIp;
        this.createUser = createUser;
        this.loginCount = loginCount;
        this.picture = picture;
        this.isDelete = isDelete;
        this.status = status;
        this.department = department;
        this.parentCode = parentCode;
        this.roleNumber = roleNumber;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Administrator() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber == null ? null : roleNumber.trim();
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