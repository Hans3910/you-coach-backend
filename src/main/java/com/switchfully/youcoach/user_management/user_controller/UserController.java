package com.switchfully.youcoach.user_management.user_controller;


import com.switchfully.youcoach.coach_management.coach_service.coach_dto.GetCoachDto;
import com.switchfully.youcoach.user_management.user_service.UserService;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetCoacheeDTO;
import com.switchfully.youcoach.user_management.user_service.user_dto.GetUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
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
    public GetCoacheeDTO signIn(@RequestParam String email) {
        return userService.signIn(email);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasAuthority('admin')")
    public List<GetUserDTO> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public GetCoacheeDTO registerUser(@RequestBody CreateUserDTO createUserDTO) {
        return userService.registerUser(createUserDTO);
    }


    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
//    @PreAuthorize("#userId == authentication.name")
    public GetCoacheeDTO getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public GetCoacheeDTO editUser(@PathVariable String userId, @RequestBody GetUserDTO getUserDTO) {
        return userService.editUser(userId, getUserDTO);
    }
}
