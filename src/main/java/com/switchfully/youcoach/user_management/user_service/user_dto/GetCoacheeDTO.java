package com.switchfully.youcoach.user_management.user_service.user_dto;

public class GetCoacheeDTO {
    private String coacheeId;
    private GetUserDTO userInfo;

    public String getCoacheeId() {
        return coacheeId;
    }

    public void setCoacheeId(String coacheeId) {
        this.coacheeId = coacheeId;
    }

    public GetUserDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(GetUserDTO userInfo) {
        this.userInfo = userInfo;
    }
}
