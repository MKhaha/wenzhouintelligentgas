package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

public class RoleResourceRelation {
    private Integer id;

    private String roleNumber;

    private String resourceNumber;

    private Integer resourceType;

    public RoleResourceRelation(Integer id, String roleNumber, String resourceNumber, Integer resourceType) {
        this.id = id;
        this.roleNumber = roleNumber;
        this.resourceNumber = resourceNumber;
        this.resourceType = resourceType;
    }

    public RoleResourceRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber == null ? null : roleNumber.trim();
    }

    public String getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(String resourceNumber) {
        this.resourceNumber = resourceNumber == null ? null : resourceNumber.trim();
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}