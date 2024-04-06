package project.codewars.Service;

import project.codewars.DTO.User.UserRequest;
import project.codewars.DTO.User.UserResponse;
import project.codewars.DTO.Warrior.WarriorRequest;
import project.codewars.entity.User;

public interface UserService {

    void registration(UserRequest userRequest);

    UserResponse login(UserRequest userRequest);

    User getUsernameFromToken(String token);
}
