package com.switchfully.youcoach.coach_management.coach_service.coach_dto;

import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;

public class GetCoachDto {
    private String id;
    private GetUserDTO getUserDto;
    private int coachXp;
    private String introduction;
    private String availability;
    private GetTopicDto getTopicDtoOne;
    private GetTopicDto getTopicDtoTwo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GetUserDTO getGetUserDto() {
        return getUserDto;
    }

    public void setGetUserDto(GetUserDTO getUserDto) {
        this.getUserDto = getUserDto;
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

    public GetTopicDto getGetTopicDtoOne() {
        return getTopicDtoOne;
    }

    public void setGetTopicDtoOne(GetTopicDto getTopicDtoOne) {
        this.getTopicDtoOne = getTopicDtoOne;
    }

    public GetTopicDto getGetTopicDtoTwo() {
        return getTopicDtoTwo;
    }

    public void setGetTopicDtoTwo(GetTopicDto getTopicDtoTwo) {
        this.getTopicDtoTwo = getTopicDtoTwo;
    }
}
