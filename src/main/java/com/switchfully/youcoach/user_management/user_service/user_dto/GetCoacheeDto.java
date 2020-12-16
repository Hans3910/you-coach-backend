package com.switchfully.youcoach.user_management.user_service.user_dto;

public class GetCoacheeDto {
    private String coacheeId;
    private GetUserDto userInfo;

    public String getCoacheeId() {
        return coacheeId;
    }

    public void setCoacheeId(String coacheeId) {
        this.coacheeId = coacheeId;
    }

    public GetUserDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(GetUserDto userInfo) {
        this.userInfo = userInfo;
    }
}
