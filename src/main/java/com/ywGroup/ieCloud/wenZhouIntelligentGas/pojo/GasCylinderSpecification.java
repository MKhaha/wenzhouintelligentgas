package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class GasCylinderSpecification {
    private Integer id;

    private String specificationNumber;

    private String specificationCode;

    private Float weight;

    private String description;

    private Float price;

    private Date createTime;

    private Date updateTime;

    public GasCylinderSpecification(Integer id, String specificationNumber, String specificationCode, Float weight, String description, Float price, Date createTime, Date updateTime) {
        this.id = id;
        this.specificationNumber = specificationNumber;
        this.specificationCode = specificationCode;
        this.weight = weight;
        this.description = description;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public GasCylinderSpecification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecificationNumber() {
        return specificationNumber;
    }

    public void setSpecificationNumber(String specificationNumber) {
        this.specificationNumber = specificationNumber == null ? null : specificationNumber.trim();
    }

    public String getSpecificationCode() {
        return specificationCode;
    }

    public void setSpecificationCode(String specificationCode) {
        this.specificationCode = specificationCode == null ? null : specificationCode.trim();
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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