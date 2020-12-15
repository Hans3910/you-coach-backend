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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TopicName getTopicName() {
        return topicName;
    }

    public void setTopicName(TopicName topicName) {
        this.topicName = topicName;
    }

    public boolean isFirstGrade() {
        return isFirstGrade;
    }

    public void setFirstGrade(boolean firstGrade) {
        isFirstGrade = firstGrade;
    }

    public boolean isSecondGrade() {
        return isSecondGrade;
    }

    public void setSecondGrade(boolean secondGrade) {
        isSecondGrade = secondGrade;
    }

    public boolean isThirdGrade() {
        return isThirdGrade;
    }

    public void setThirdGrade(boolean thirdGrade) {
        isThirdGrade = thirdGrade;
    }

    public boolean isFourthGrade() {
        return isFourthGrade;
    }

    public void setFourthGrade(boolean fourthGrade) {
        isFourthGrade = fourthGrade;
    }

    public boolean isFifthGrade() {
        return isFifthGrade;
    }

    public void setFifthGrade(boolean fifthGrade) {
        isFifthGrade = fifthGrade;
    }

    public boolean isSixthGrade() {
        return isSixthGrade;
    }

    public void setSixthGrade(boolean sixthGrade) {
        isSixthGrade = sixthGrade;
    }

    public boolean isSeventhGrade() {
        return isSeventhGrade;
    }

    public void setSeventhGrade(boolean seventhGrade) {
        isSeventhGrade = seventhGrade;
    }
}
