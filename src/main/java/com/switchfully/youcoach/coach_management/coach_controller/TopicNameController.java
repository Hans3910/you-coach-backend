package com.switchfully.youcoach.coach_management.coach_controller;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetTopicNameDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/topics")
public class TopicNameController {
    private TopicService topicService;

    @Autowired
    public TopicNameController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<GetTopicNameDto> getAllTopicNames(){
       return topicService.getAllTopics();
    }

}
