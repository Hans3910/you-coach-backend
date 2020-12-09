package com.switchfully.youcoach.user_management.user_domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class User {

    //Id: long or UUID? UUID
    //Security and users: what are we supposed to do with that? Not much, for now.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Embedded
    @Column
    private Email email;
    //private Email password;
    @OneToOne
    @JoinColumn
    private Coachee coachee;

    public User(String firstName, String lastName, Email email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.coachee = new Coachee();
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Coachee getCoachee() {
        return coachee;
    }
}
