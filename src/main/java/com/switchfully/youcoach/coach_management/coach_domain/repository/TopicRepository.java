package com.switchfully.youcoach.coach_management.coach_domain.repository;

import com.switchfully.youcoach.coach_management.coach_domain.entity.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TopicRepository extends CrudRepository<Topic, UUID> {
}
