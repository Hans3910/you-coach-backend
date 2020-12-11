package com.switchfully.youcoach.session.session_domain.entity;

import com.switchfully.youcoach.user_management.user_domain.entity.Coach;
import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class Session {
    @Id
    private UUID id;
    @ManyToOne
    private Coachee coachee;
    @ManyToOne
    private Coach coach;
    @Column
    private String subject;
    @Column
    private LocalDate requestedDate;
    @Column
    private LocalTime requestedTime;
    @Column
    private String location;
    @Column
    private String remarks;

    public Session(Coachee coachee, Coach coach, String subject, LocalDate requestedDate, LocalTime requestedTime, String location, String remarks) {
        this.id = UUID.randomUUID();
        this.coachee = coachee;
        this.coach = coach;
        this.subject = subject;
        this.requestedDate = requestedDate;
        this.requestedTime = requestedTime;
        this.location = location;
        this.remarks = remarks;
    }

    public Session() {    }

    public UUID getId() {
        return id;
    }

    public Coachee getCoachee() {
        return coachee;
    }

    public void setCoachee(Coachee coachee) {
        this.coachee = coachee;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(LocalDate requestedDate) {
        this.requestedDate = requestedDate;
    }

    public LocalTime getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(LocalTime requestedTime) {
        this.requestedTime = requestedTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
