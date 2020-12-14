package com.switchfully.youcoach.coach_management.coach_domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private int coachXp;
    @Column
    private String introduction;
    @Column
    private String availability;
    @OneToOne
    private Topic topicOne;
    @OneToOne
    private Topic topicTwo;

    public Coach() {
    }

    public UUID getId() {
        return id;
    }
}
