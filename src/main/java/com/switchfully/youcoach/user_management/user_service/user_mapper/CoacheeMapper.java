package com.switchfully.youcoach.user_management.user_service.user_mapper;

import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDTO;
import org.springframework.stereotype.Component;

@Component
public class CoacheeMapper {
    public GetCoacheeDTO convertCoacheeToGetCoacheeDTO(Coachee coachee) {
        GetCoacheeDTO getCoacheeDTO = new GetCoacheeDTO();
        getCoacheeDTO.setId(coachee.getId().toString());
        return getCoacheeDTO;
    }
}
