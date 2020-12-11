package com.switchfully.youcoach.session.session_service;

import com.switchfully.youcoach.exceptions.UserNotFoundException;
import com.switchfully.youcoach.session.session_domain.repository.SessionRepository;
import com.switchfully.youcoach.session.session_service.session_dto.CreateSessionDto;
import com.switchfully.youcoach.session.session_service.session_mapper.SessionMapper;
import com.switchfully.youcoach.user_management.user_domain.entity.Coach;
import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;
import com.switchfully.youcoach.user_management.user_domain.repository.CoachRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.CoacheeRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {

    private SessionMapper sessionMapper;
    private SessionRepository sessionRepository;
    private UserRepository userRepository;
    private CoacheeRepository coacheeRepository;
    private CoachRepository coachRepository;

    public SessionService(SessionMapper sessionMapper, SessionRepository sessionRepository, UserRepository userRepository, CoacheeRepository coacheeRepository, CoachRepository coachRepository) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
        this.coacheeRepository = coacheeRepository;
        this.coachRepository = coachRepository;
    }

    public void createSession(CreateSessionDto createSessionDto){
        Optional<Coachee> optionalCoachee = coacheeRepository.findById(UUID.fromString(createSessionDto.getCoacheeId()));
        Optional<Coach> optionalCoach =  coachRepository.findById(UUID.fromString(createSessionDto.getCoachId()));
        if (optionalCoach.isEmpty()||optionalCoachee.isEmpty()){
            throw new UserNotFoundException("Coach or coachee is not registered in the system");
        }
        sessionRepository.save(sessionMapper.convertSessionDtoToSession(createSessionDto,optionalCoachee.get(),optionalCoach.get()));
    }

}
