package com.switchfully.youcoach.user_management.user_service.user_dto;

import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;

public class GetUserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private GetCoacheeDTO getCoacheeDTO;
    private GetCoachDto getCoachDto;
    private String pictureUrl;

    public GetCoachDto getGetCoachDto() {
        return getCoachDto;
    }

    public void setGetCoachDto(GetCoachDto getCoachDto) {
        this.getCoachDto = getCoachDto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GetCoacheeDTO getGetCoacheeDTO() {
        return getCoacheeDTO;
    }

    public void setGetCoacheeDTO(GetCoacheeDTO getCoacheeDTO) {
        this.getCoacheeDTO = getCoacheeDTO;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
