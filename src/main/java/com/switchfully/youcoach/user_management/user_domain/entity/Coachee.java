package com.switchfully.youcoach.user_management.user_domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Coachee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public UUID getId() {
        return id;
    }
}
