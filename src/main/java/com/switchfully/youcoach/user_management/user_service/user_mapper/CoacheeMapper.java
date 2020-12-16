package com.switchfully.youcoach.user_management.user_service.user_mapper;

import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoacheeMapper {
    public GetCoacheeDto convertCoacheeToGetCoacheeDTO(Coachee coachee, GetUserDto getUserDto) {
        GetCoacheeDto getCoacheeDTO = new GetCoacheeDto();
        getCoacheeDTO.setCoacheeId(coachee.getId().toString());
        getCoacheeDTO.setUserInfo(getUserDto);
        return getCoacheeDTO;
    }

}
