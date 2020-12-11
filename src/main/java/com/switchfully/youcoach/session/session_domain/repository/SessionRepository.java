package com.switchfully.youcoach.session.session_domain.repository;

import com.switchfully.youcoach.session.session_domain.entity.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SessionRepository extends CrudRepository<Session, UUID> {

}
