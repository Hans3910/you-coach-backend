package com.switchfully.youcoach.coach_management.coach_controller;

import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/coach")
public class CoachController {
    private CoachService coachService;
    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping(path = "/{coachId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GetCoachDto getCoachById(@PathVariable String coachId){
        return coachService.getCoachById(coachId);
    }

    @PostMapping(path = "/{coachId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GetCoachDto editCoach(@PathVariable String coachId, @RequestBody GetCoachDto getCoachDto) {
        return coachService.editCoach(coachId, getCoachDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetCoachDto> getAllCoaches(){
        return coachService.getAllCoaches();
    }
}
