package com.switchfully.youcoach.user_management.user_controller;


import com.switchfully.youcoach.user_management.user_service.UserService;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDto;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/users")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/signIn", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GetCoacheeDto signIn(@RequestParam String email) {
        return userService.signIn(email);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasAuthority('admin')")
    public List<GetUserDto> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public GetCoacheeDto registerUser(@RequestBody CreateUserDto createUserDTO) {
        return userService.registerUser(createUserDTO);
    }


    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
//    @PreAuthorize("#userId == authentication.name")
    public GetCoacheeDto getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public GetCoacheeDto editUser(@PathVariable String userId, @RequestBody GetUserDto getUserDTO) {
        return userService.editUser(userId, getUserDTO);
    }
}
