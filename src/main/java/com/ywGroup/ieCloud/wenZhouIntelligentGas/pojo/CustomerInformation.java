package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

public class CustomerInformation {
    private Long id;

    private String gas;

    private String onSite;

    private String customerCode;

    private String clientName;

    private String gender;

    private String customerType;

    private String contactNumber;

    private String contactAddress;

    private String contactPerson;

    private String businessLicenseNumber;

    private String manager;

    private String main;

    private String itsAdministrativeArea;

    private String idNumber;

    private String contactTelephone2;

    private String contactTelephone3;

    public CustomerInformation(Long id, String gas, String onSite, String customerCode, String clientName, String gender, String customerType, String contactNumber, String contactAddress, String contactPerson, String businessLicenseNumber, String manager, String main, String itsAdministrativeArea, String idNumber, String contactTelephone2, String contactTelephone3) {
        this.id = id;
        this.gas = gas;
        this.onSite = onSite;
        this.customerCode = customerCode;
        this.clientName = clientName;
        this.gender = gender;
        this.customerType = customerType;
        this.contactNumber = contactNumber;
        this.contactAddress = contactAddress;
        this.contactPerson = contactPerson;
        this.businessLicenseNumber = businessLicenseNumber;
        this.manager = manager;
        this.main = main;
        this.itsAdministrativeArea = itsAdministrativeArea;
        this.idNumber = idNumber;
        this.contactTelephone2 = contactTelephone2;
        this.contactTelephone3 = contactTelephone3;
    }

    public CustomerInformation() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas == null ? null : gas.trim();
    }

    public String getOnSite() {
        return onSite;
    }

    public void setOnSite(String onSite) {
        this.onSite = onSite == null ? null : onSite.trim();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber == null ? null : businessLicenseNumber.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main == null ? null : main.trim();
    }

    public String getItsAdministrativeArea() {
        return itsAdministrativeArea;
    }

    public void setItsAdministrativeArea(String itsAdministrativeArea) {
        this.itsAdministrativeArea = itsAdministrativeArea == null ? null : itsAdministrativeArea.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getContactTelephone2() {
        return contactTelephone2;
    }

    public void setContactTelephone2(String contactTelephone2) {
        this.contactTelephone2 = contactTelephone2 == null ? null : contactTelephone2.trim();
    }

    public String getContactTelephone3() {
        return contactTelephone3;
    }

    public void setContactTelephone3(String contactTelephone3) {
        this.contactTelephone3 = contactTelephone3 == null ? null : contactTelephone3.trim();
    }
}