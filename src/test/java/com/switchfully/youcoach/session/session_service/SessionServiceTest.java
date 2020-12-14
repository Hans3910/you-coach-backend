package com.switchfully.youcoach.session.session_service;

import com.switchfully.youcoach.exceptions.UserNotFoundException;
import com.switchfully.youcoach.session.session_domain.entity.Session;
import com.switchfully.youcoach.session.session_domain.repository.SessionRepository;
import com.switchfully.youcoach.session.session_service.session_dto.CreateSessionDto;
import com.switchfully.youcoach.session.session_service.session_mapper.SessionMapper;
import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import com.switchfully.youcoach.user_management.user_domain.entity.Coachee;
import com.switchfully.youcoach.user_management.user_domain.repository.CoachRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.CoacheeRepository;
import com.switchfully.youcoach.user_management.user_domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

class SessionServiceTest {

    private SessionMapper sessionMapper;
    private SessionRepository sessionRepository;
    private UserRepository userRepository;
    private CoachRepository coachRepository;
    private CoacheeRepository coacheeRepository;
    private SessionService sessionService;

    @BeforeEach
    public void setup(){
        sessionMapper = Mockito.mock(SessionMapper.class);
        sessionRepository = Mockito.mock(SessionRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        coacheeRepository = Mockito.mock(CoacheeRepository.class);
        coachRepository = Mockito.mock(CoachRepository.class);
        sessionService = new SessionService(sessionMapper,sessionRepository,userRepository,coacheeRepository,coachRepository);
    }

    @Test
    public void givenCorrectCoachAndCoachee_sessionIsCreated_happypath(){
        UUID coachId = UUID.randomUUID();
        UUID coacheeId = UUID.randomUUID();
        Optional<Coachee> optionalCoachee = Optional.of(new Coachee());
        Optional<Coach> optionalCoach = Optional.of(new Coach());
        Session session = new Session();
        CreateSessionDto createSessionDto = new CreateSessionDto(coacheeId.toString(),coachId.toString(),"Biology","12-12-2020","14:00","Haasrode","remarky");
        Mockito.when(coacheeRepository.findById(coacheeId)).thenReturn(optionalCoachee);
        Mockito.when(coachRepository.findById(coachId)).thenReturn(optionalCoach);
        Mockito.when(sessionMapper.convertSessionDtoToSession(createSessionDto, optionalCoachee.get(), optionalCoach.get())).thenReturn(session);
        sessionService.createSession(createSessionDto);
        Mockito.verify(sessionRepository).save(session);
    }
    @Test
    public void givenWrongCoacheeAndCorrectCoach_thenUserNotFOundException(){
        UUID coachId = UUID.randomUUID();
        UUID coacheeId = UUID.randomUUID();
        Optional<Coach> optionalCoach = Optional.of(new Coach());
        CreateSessionDto createSessionDto = new CreateSessionDto(coacheeId.toString(),coachId.toString(),"Biology","12-12-2020","14:00","Haasrode","remarky");
        Mockito.when(coacheeRepository.findById(coacheeId)).thenReturn(Optional.empty());
        Mockito.when(coachRepository.findById(coachId)).thenReturn(optionalCoach);
        Assertions.assertThrows(UserNotFoundException.class, ()-> sessionService.createSession(createSessionDto));
    }

    @Test
    public void givenWrongCoachAndCorrectCoachee_thenUserNotFOundException(){
        UUID coachId = UUID.randomUUID();
        UUID coacheeId = UUID.randomUUID();
        Optional<Coachee> optionalCoachee = Optional.of(new Coachee());
        CreateSessionDto createSessionDto = new CreateSessionDto(coacheeId.toString(),coachId.toString(),"Biology","12-12-2020","14:00","Haasrode","remarky");
        Mockito.when(coacheeRepository.findById(coacheeId)).thenReturn(optionalCoachee);
        Mockito.when(coachRepository.findById(coachId)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, ()-> sessionService.createSession(createSessionDto));
    }
    @Test
    public void givenWrongCoachAndWrongCoachee_thenUserNotFOundException(){
        UUID coachId = UUID.randomUUID();
        UUID coacheeId = UUID.randomUUID();
        CreateSessionDto createSessionDto = new CreateSessionDto(coacheeId.toString(),coachId.toString(),"Biology","12-12-2020","14:00","Haasrode","remarky");
        Mockito.when(coacheeRepository.findById(coacheeId)).thenReturn(Optional.empty());
        Mockito.when(coachRepository.findById(coachId)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, ()-> sessionService.createSession(createSessionDto));
    }

}
