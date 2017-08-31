package com.ywGroup.ieCloud.wenZhouIntelligentGas.pojo;

import java.util.Date;

public class AlarmEventRecord {
    private Integer id;

    private String eventId;

    private Integer grade;

    private String eventDetail;

    private String eventPictureAddress;

    private String eventSponsor;

    private Date eventStartTime;

    private String status;

    private Date eventEndTime;

    private String administrativeRegions;

    public AlarmEventRecord(Integer id, String eventId, Integer grade, String eventDetail, String eventPictureAddress, String eventSponsor, Date eventStartTime, String status, Date eventEndTime, String administrativeRegions) {
        this.id = id;
        this.eventId = eventId;
        this.grade = grade;
        this.eventDetail = eventDetail;
        this.eventPictureAddress = eventPictureAddress;
        this.eventSponsor = eventSponsor;
        this.eventStartTime = eventStartTime;
        this.status = status;
        this.eventEndTime = eventEndTime;
        this.administrativeRegions = administrativeRegions;
    }

    public AlarmEventRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail == null ? null : eventDetail.trim();
    }

    public String getEventPictureAddress() {
        return eventPictureAddress;
    }

    public void setEventPictureAddress(String eventPictureAddress) {
        this.eventPictureAddress = eventPictureAddress == null ? null : eventPictureAddress.trim();
    }

    public String getEventSponsor() {
        return eventSponsor;
    }

    public void setEventSponsor(String eventSponsor) {
        this.eventSponsor = eventSponsor == null ? null : eventSponsor.trim();
    }

    public Date getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Date eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getAdministrativeRegions() {
        return administrativeRegions;
    }

    public void setAdministrativeRegions(String administrativeRegions) {
        this.administrativeRegions = administrativeRegions == null ? null : administrativeRegions.trim();
    }
}