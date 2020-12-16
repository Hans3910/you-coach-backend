package com.switchfully.youcoach.coach_management.coach_service.coach_dto;

import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDto;

public class GetCoachOverviewDto {
    private GetUserDto getUserDto;
    private GetTopicDto topicOne;
    private GetTopicDto topicTwo;

    public GetUserDto getGetUserDto() {
        return getUserDto;
    }

    public void setGetUserDto(GetUserDto getUserDto) {
        this.getUserDto = getUserDto;
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
}
