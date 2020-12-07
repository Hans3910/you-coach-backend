package com.switchfully.youcoach.user_management.user_controller;


import com.switchfully.youcoach.user_management.user_domain.UserService;
import com.switchfully.youcoach.user_management.user_dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/users")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody CreateUserDTO createUserDTO) {
        userService.registerUser(createUserDTO);
    }
}
