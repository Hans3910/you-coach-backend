package com.switchfully.skeleton.security.authentication.user;

public interface SecuredUserRepository {
    SecuredUser findByUsername(String username);
}
