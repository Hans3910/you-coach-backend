package com.switchfully.youcoach.session.session_service;

import com.switchfully.youcoach.exceptions.UserNotFoundException;
import com.switchfully.youcoach.session.session_domain.repository.SessionRepository;
import com.switchfully.youcoach.session.session_service.session_dto.CreateSessionDto;
import com.switchfully.youcoach.session.session_service.session_dto.SessionDto;
import com.switchfully.youcoach.session.session_service.session_mapper.SessionMapper;
import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;
import com.switchfully.youcoach.user_management.user_domain.repository.CoachRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.CoacheeRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public void createSession(CreateSessionDto createSessionDto) {
        Optional<Coachee> optionalCoachee = coacheeRepository.findById(UUID.fromString(createSessionDto.getCoacheeId()));
        Optional<Coach> optionalCoach = coachRepository.findById(UUID.fromString(createSessionDto.getCoachId()));
        if (optionalCoach.isEmpty() || optionalCoachee.isEmpty()) {
            throw new UserNotFoundException("Coach or coachee is not registered in the system");
        }
        sessionRepository.save(sessionMapper.convertSessionDtoToSession(createSessionDto, optionalCoachee.get(), optionalCoach.get()));
    }

    public List<SessionDto> getAllSessionsForACoachee(String coacheeId) {
        List<SessionDto> result = sessionRepository.findByCoachee_Id(UUID.fromString(coacheeId))
                .stream()
                .map(session -> sessionMapper.convertSessionToSessionDto(session))
                .collect(Collectors.toList());

        result.forEach(sessionDTO -> sessionDTO.setCoacheeFullName(userRepository.findByCoachee_Id(UUID.fromString(sessionDTO.getCoacheeId())).get().getFullName()));
        result.forEach(sessionDTO -> sessionDTO.setCoachFullName(userRepository.findByCoach_Id(UUID.fromString(sessionDTO.getCoachId())).get().getFullName()));

        return result;

    }

    public List<SessionDto> getAllSessionsForACoach(String coachId) {
        List<SessionDto> result = sessionRepository.findByCoach_Id(UUID.fromString(coachId))
                .stream()
                .map(session -> sessionMapper.convertSessionToSessionDto(session))
                .collect(Collectors.toList());

        result.forEach(sessionDTO -> sessionDTO.setCoacheeFullName(userRepository.findByCoachee_Id(UUID.fromString(sessionDTO.getCoacheeId())).get().getFullName()));
        result.forEach(sessionDTO -> sessionDTO.setCoachFullName(userRepository.findByCoach_Id(UUID.fromString(sessionDTO.getCoachId())).get().getFullName()));

        return result;

    }
}
