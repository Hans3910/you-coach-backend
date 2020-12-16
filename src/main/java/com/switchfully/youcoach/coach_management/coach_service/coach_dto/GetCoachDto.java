package com.switchfully.youcoach.coach_management.coach_service.coach_dto;

import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDto;

public class GetCoachDto {
    private String coachId;
    private GetUserDto userInfo;
    private int coachXp;
    private String introduction;
    private String availability;
    private GetTopicDto topicOne;
    private GetTopicDto topicTwo;

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public GetUserDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(GetUserDto userInfo) {
        this.userInfo = userInfo;
    }

    public int getCoachXp() {
        return coachXp;
    }

    public void setCoachXp(int coachXp) {
        this.coachXp = coachXp;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public GetTopicDto getTopicOne() {
        return topicOne;
    }

    public void setTopicOne(GetTopicDto topicOne) {
        this.topicOne = topicOne;
    }

    public GetTopicDto getTopicTwo() {
        return topicTwo;
    }

    public void setTopicTwo(GetTopicDto topicTwo) {
        this.topicTwo = topicTwo;
    }

    @Override
    public String toString() {
        return "GetCoachDto{" +
                "coachId='" + coachId + '\'' +
                ", userInfo=" + userInfo +
                ", coachXp=" + coachXp +
                ", introduction='" + introduction + '\'' +
                ", availability='" + availability + '\'' +
                ", topicOne=" + topicOne +
                ", topicTwo=" + topicTwo +
                '}';
    }
}
