package project.codewars.DTO.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String email;
    private String password;
    private String username;

}
