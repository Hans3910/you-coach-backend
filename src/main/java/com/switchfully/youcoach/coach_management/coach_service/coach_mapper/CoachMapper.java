package com.switchfully.youcoach.coach_management.coach_service.coach_mapper;

import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import com.switchfully.youcoach.coach_management.coach_domain.entity.Topic;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;
import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetTopicDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDto;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {
    public GetCoachDto convertCoachToGetCoachDto(Coach coach, GetUserDto getUserDTO){
        GetCoachDto getCoachDto = new GetCoachDto();
        getCoachDto.setCoachXp(coach.getCoachXp());
        getCoachDto.setAvailability(coach.getAvailability());
        getCoachDto.setIntroduction(coach.getIntroduction());
        getCoachDto.setCoachId(coach.getId().toString());
        getCoachDto.setTopicOne(coach.getTopicOne()!=null? convertTopicToDto(coach.getTopicOne()): new GetTopicDto());
        getCoachDto.setTopicTwo(coach.getTopicTwo()!=null? convertTopicToDto(coach.getTopicTwo()): new GetTopicDto());
        getCoachDto.setUserInfo(getUserDTO);
        return getCoachDto;
    }

    public GetTopicDto convertTopicToDto (Topic topic){
        GetTopicDto getTopicDto = new GetTopicDto();
        getTopicDto.setTopicId(topic.getId().toString());
        getTopicDto.setName(topic.getTopicName().getName());
        getTopicDto.setFirstGrade(topic.isFirstGrade());
        getTopicDto.setSecondGrade(topic.isSecondGrade());
        getTopicDto.setThirdGrade(topic.isThirdGrade());
        getTopicDto.setFourthGrade(topic.isFourthGrade());
        getTopicDto.setFifthGrade(topic.isFifthGrade());
        getTopicDto.setSixthGrade(topic.isSixthGrade());
        getTopicDto.setSeventhGrade(topic.isSeventhGrade());
        return getTopicDto;
    }



}
