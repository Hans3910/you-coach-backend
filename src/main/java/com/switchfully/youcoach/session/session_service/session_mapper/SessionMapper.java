package com.switchfully.youcoach.session.session_service.session_mapper;

import com.switchfully.youcoach.session.session_domain.entity.Session;
import com.switchfully.youcoach.session.session_service.session_dto.CreateSessionDto;
import com.switchfully.youcoach.session.session_service.session_dto.SessionDto;
import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;
import com.switchfully.youcoach.user_management.user_domain.entity.User;
import com.switchfully.youcoach.util.FormatUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
@Component
public class SessionMapper {

    public Session convertSessionDtoToSession(CreateSessionDto sessionDto, Coachee coachee, Coach coach){
        return new Session(coachee, coach, sessionDto.getSubject(), LocalDate.parse(sessionDto.getRequestedDate()),
                LocalTime.parse(sessionDto.getRequestedTime(), FormatUtil.getTimeFormat()), sessionDto.getLocation(), sessionDto.getRemarks());
    }

    public SessionDto convertSessionToSessionDto(Session session){
        return new SessionDto(session.getId().toString(),
                session.getCoachee().getId().toString(),
                session.getCoach().getId().toString(),
                session.getSubject(),
                session.getRequestedDate().format(FormatUtil.getDateFormat()),
                session.getRequestedTime().format(FormatUtil.getTimeFormat()),
                session.getLocation());
    }


}
