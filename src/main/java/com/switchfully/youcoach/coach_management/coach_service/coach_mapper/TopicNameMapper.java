package com.switchfully.youcoach.coach_management.coach_service.coach_mapper;

import com.switchfully.youcoach.coach_management.coach_domain.entity.TopicName;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetTopicNameDto;
import org.springframework.stereotype.Component;

@Component
public class TopicNameMapper {
    public GetTopicNameDto convertTopicNameToTopicNameDto(TopicName topicName) {
        GetTopicNameDto getTopicNameDto = new GetTopicNameDto();
        getTopicNameDto.setName(topicName.getName());
        return getTopicNameDto;
    }
}
