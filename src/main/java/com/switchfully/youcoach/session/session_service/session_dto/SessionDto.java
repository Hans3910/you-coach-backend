package com.switchfully.youcoach.session.session_service.session_dto;

public class SessionDto {

        private String id;
        private String coacheeId;
        private String coachId;
        private String subject;
        private String requestedDate;
        private String requestedTime;
        private String location;
        private String coacheeFullName;
        private String coachFullName;

    public SessionDto() {
    }

    public SessionDto(String id, String coacheeId, String coachId, String subject, String requestedDate, String requestedTime, String location) {
        this.id = id;
        this.coacheeId = coacheeId;
        this.coachId = coachId;
        this.subject = subject;
        this.requestedDate = requestedDate;
        this.requestedTime = requestedTime;
        this.location = location;
        this.coacheeFullName = "";
        this.coachFullName = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoacheeId() {
        return coacheeId;
    }

    public void setCoacheeId(String coacheeId) {
        this.coacheeId = coacheeId;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(String requestedTime) {
        this.requestedTime = requestedTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCoacheeFullName(String coacheeFullName) {this.coacheeFullName = coacheeFullName;}

    public void setCoachFullName(String coachFullName) {this.coachFullName = coachFullName;}

    public String getCoacheeFullName() {
        return coacheeFullName;
    }

    public String getCoachFullName() {
        return coachFullName;
    }
}
