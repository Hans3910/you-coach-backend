package com.switchfully.youcoach.coach_management.coach_service.coach_dto;

public class GetTopicDto {
    private String topicId;
    private String name;
    private boolean isFirstGrade;
    private boolean isSecondGrade;
    private boolean isThirdGrade;
    private boolean isFourthGrade;
    private boolean isFifthGrade;
    private boolean isSixthGrade;
    private boolean isSeventhGrade;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
