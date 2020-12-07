package com.switchfully.youcoach.user_management.user_domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    public boolean existsDistinctByEmail(Email email);
}
