package com.switchfully.youcoach.coach_management.coach_domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "topic_name")
public class TopicName {
    @Id
    private String name;


}
