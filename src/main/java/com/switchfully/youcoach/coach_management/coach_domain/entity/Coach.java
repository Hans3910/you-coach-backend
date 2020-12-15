package com.switchfully.youcoach.coach_management.coach_domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "coach")
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
    @JoinColumn(name = "topic_one_id")
    private Topic topicOne;
    @OneToOne
    @JoinColumn(name = "topic_two_id")
    private Topic topicTwo;

    public Coach() {
    }

    public UUID getId() {
        return id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getAvailability() {
        return availability;
    }

    public Topic getTopicOne() {
        return topicOne;
    }

    public Topic getTopicTwo() {
        return topicTwo;
    }
}
