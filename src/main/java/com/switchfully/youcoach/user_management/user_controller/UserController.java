package com.switchfully.youcoach.user_management.user_controller;


import com.switchfully.youcoach.user_management.user_service.UserService;
import com.switchfully.youcoach.user_management.user_service.user_dto.CreateUserDTO;
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
    public GetUserDTO signIn(@RequestParam String email) {
        return userService.signIn(email);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasAuthority('admin')")
    public List<GetUserDTO> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody CreateUserDTO createUserDTO) {
        userService.registerUser(createUserDTO);
    }


    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
//    @PreAuthorize("#userId == authentication.name")
    public GetUserDTO getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }
}
