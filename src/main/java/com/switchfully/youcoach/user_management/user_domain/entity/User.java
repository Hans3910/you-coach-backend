package com.switchfully.youcoach.user_management.user_domain.entity;

import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
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
    @OneToOne
    @JoinColumn
    private Coach coach;
    @Column
    private String pictureUrl;

//    We will probably need an admin at some point. In the meantime...
//    @OneToOne
//    @JoinColumn
//    private Admin admin;

    //TODO: When do you actually become a coach? It is never mentioned in the stories. Ask Karel & Christoph

    public User(String firstName, String lastName, Email email) {

        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.coachee = new Coachee();
        this.coach = null;
        this.pictureUrl = "";
//       this.admin= null;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setCoachee(Coachee coachee) {
        this.coachee = coachee;
    }

    public String getFullName() { return firstName+" "+lastName; }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
