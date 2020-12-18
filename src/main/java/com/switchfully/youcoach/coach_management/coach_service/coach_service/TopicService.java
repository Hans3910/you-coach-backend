package com.switchfully.youcoach.coach_management.coach_service.coach_service;

import com.switchfully.youcoach.coach_management.coach_domain.entity.TopicName;
import com.switchfully.youcoach.coach_management.coach_domain.repository.TopicNameRepository;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetTopicNameDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_mapper.TopicNameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TopicService {
    private TopicNameRepository topicNameRepository;
    private TopicNameMapper topicNameMapper;

    @Autowired
    public TopicService(TopicNameRepository topicNameRepository, TopicNameMapper topicNameMapper) {
        this.topicNameRepository = topicNameRepository;
        this.topicNameMapper = topicNameMapper;
    }

    public List<GetTopicNameDto> getAllTopics(){
       return StreamSupport.stream(topicNameRepository.findAll().spliterator(), false)
               .map(topicName -> topicNameMapper.convertTopicNameToTopicNameDto(topicName))
                .collect(Collectors.toList());
    }
}
