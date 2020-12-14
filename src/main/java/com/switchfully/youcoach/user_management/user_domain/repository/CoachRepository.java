package com.switchfully.youcoach.user_management.user_domain.repository;

import com.switchfully.youcoach.coach_management.coach_domain.entity.Coach;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CoachRepository extends CrudRepository<Coach, UUID> {
}
