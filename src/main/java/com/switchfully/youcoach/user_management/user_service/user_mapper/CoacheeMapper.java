package com.switchfully.youcoach.user_management.user_service.user_mapper;

import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CoacheeMapper {
    public GetCoacheeDTO convertCoacheeToGetCoacheeDTO(Coachee coachee, GetUserDTO getUserDto) {
        GetCoacheeDTO getCoacheeDTO = new GetCoacheeDTO();
        getCoacheeDTO.setCoacheeId(coachee.getId().toString());
        getCoacheeDTO.setUserInfo(getUserDto);
        return getCoacheeDTO;
    }
}
