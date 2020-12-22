package com.switchfully.youcoach.session.session_controller;

import com.switchfully.youcoach.session.session_domain.repository.SessionRepository;
import com.switchfully.youcoach.session.session_service.SessionService;
import com.switchfully.youcoach.session.session_service.session_dto.CreateSessionDto;
import com.switchfully.youcoach.session.session_service.session_dto.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sessions")
public class SessionController {

    private SessionService sessionService;
    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createSession(@RequestBody CreateSessionDto createSessionDto){
        System.out.println(createSessionDto);
        sessionService.createSession(createSessionDto);
    }

    @GetMapping(path = "/coacheeSessions/{coacheeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SessionDto> getAllSessionsForACoachee(@PathVariable String coacheeId) {
        return sessionService.getAllSessionsForACoachee(coacheeId);
    }

    @GetMapping(path = "/coachSessions/{coachId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SessionDto> getAllSessionsForACoach(@PathVariable String coachId) {
        return sessionService.getAllSessionsForACoach(coachId);
    }
}
