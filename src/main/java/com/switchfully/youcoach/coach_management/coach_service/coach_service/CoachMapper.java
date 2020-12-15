package com.switchfully.youcoach.coach_management.coach_service.coach_service;

import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {
    public GetCoachDto convertCoachToGetCoachDto(GetUserDTO getUserDTO){
        GetCoachDto getCoachDto = new GetCoachDto();
        getCoachDto.setGetUserDto(getUserDTO);
        return getCoachDto;
    }
}
