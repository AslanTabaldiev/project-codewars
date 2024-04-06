package project.codewars.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import project.codewars.DTO.User.UserRequest;
import project.codewars.DTO.User.UserResponse;
import project.codewars.DTO.Warrior.WarriorRequest;
import project.codewars.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public void registration(@RequestBody UserRequest userRequest) {
        userService.registration(userRequest);
    }

    @PostMapping("/login")
    public UserResponse login(UserRequest userRequest) {
        return userService.login(userRequest);
    }
}
