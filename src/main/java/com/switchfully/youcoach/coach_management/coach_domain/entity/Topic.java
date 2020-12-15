package com.switchfully.youcoach.coach_management.coach_domain.entity;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "topic_name")
    private TopicName topicName;

    private boolean isFirstGrade;
    private boolean isSecondGrade;
    private boolean isThirdGrade;
    private boolean isFourthGrade;
    private boolean isFifthGrade;
    private boolean isSixthGrade;
    private boolean isSeventhGrade;
}
