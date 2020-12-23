package com.switchfully.youcoach.session.session_domain.repository;

import com.switchfully.youcoach.session.session_domain.entity.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SessionRepository extends CrudRepository<Session, UUID> {

    public List<Session> findByCoach_Id(UUID coachId);
    public List<Session> findByCoachee_Id(UUID coacheeId);
}
