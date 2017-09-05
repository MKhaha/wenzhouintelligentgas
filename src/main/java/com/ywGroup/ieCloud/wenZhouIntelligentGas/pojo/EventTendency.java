package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class EventTendency {
    private Integer id;

    private Integer eventNumber;

    private Date eventTime;

    private String administrativeRegions;

    public EventTendency(Integer id, Integer eventNumber, Date eventTime, String administrativeRegions) {
        this.id = id;
        this.eventNumber = eventNumber;
        this.eventTime = eventTime;
        this.administrativeRegions = administrativeRegions;
    }

    public EventTendency() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(Integer eventNumber) {
        this.eventNumber = eventNumber;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getAdministrativeRegions() {
        return administrativeRegions;
    }

    public void setAdministrativeRegions(String administrativeRegions) {
        this.administrativeRegions = administrativeRegions;
    }
}