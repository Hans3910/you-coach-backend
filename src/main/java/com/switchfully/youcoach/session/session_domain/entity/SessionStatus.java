package com.switchfully.youcoach.session.session_domain.entity;

public enum SessionStatus {
    REQUESTED("Requested"),
    ACCEPTED("Accepted"),
    DECLINED("Declined"),
    CANCELLED_BY_COACHEE("Cancelled by coachee"),
    CANCELLED_BY_COACH("Cancelled by coach"),
    WAITING_FOR_FEEDBACK("Waiting for feedback"),
    FINISHED("Finished");

    private String status;

    SessionStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
