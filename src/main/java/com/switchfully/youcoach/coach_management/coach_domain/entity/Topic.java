package com.switchfully.youcoach.coach_management.coach_domain.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;
@Entity
public class Topic {
    @Id
    private UUID id;
    @ManyToOne
    private TopicName name;

    private boolean isFirstGrade;
    private boolean isSecondGrade;
    private boolean isThirdGrade;
    private boolean isFourthGrade;
    private boolean isFifthGrade;
    private boolean isSixthGrade;
    private boolean isSeventhGrade;
}
