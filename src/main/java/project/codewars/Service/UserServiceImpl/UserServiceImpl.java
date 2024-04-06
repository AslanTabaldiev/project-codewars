package project.codewars.Service.UserServiceImpl;

import project.codewars.DTO.User.UserRequest;
import project.codewars.DTO.User.UserResponse;
import project.codewars.DTO.Warrior.WarriorRequest;
import project.codewars.Enum.Role;
import project.codewars.Repositories.UserRepository;
import project.codewars.Service.UserService;
import project.codewars.config.JwtService;
import project.codewars.entity.User;
import project.codewars.entity.Warrior;
import project.codewars.exception.NotFoundException;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public void registration(UserRequest userRequest) {
        if(userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new BadCredentialsException("User with this email is already exist");
        }
        User user = new User();
        user.setRole(Role.Admin);
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

//        Warrior warrior = new Warrior();
//        warrior.setUsername(warriorRequest.getUsername());
//        warrior.setWarrior_rank(8);
//        warrior.setRegistration_date(LocalDate.now().toString());

        userRepository.save(user);
    }

    @Override
    public UserResponse login(UserRequest userRequest) {
        Optional<User> user = userRepository.findByEmail(userRequest.getEmail());
        if(user.isEmpty()) {
            throw new NotFoundException("User is not found", HttpStatus.BAD_REQUEST);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(),userRequest.getPassword()));

        }catch (BadCredentialsException e){
            throw new BadCredentialsException("User is not found");
        }
        return convertToResponse(user);
    }


    @Override
    public User getUsernameFromToken(String token) {
        String[] chunks = token.substring(7).split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) jsonParser.parse(decoder.decode(chunks[1]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return userRepository.findByEmail(String.valueOf(object.get("sub"))).orElseThrow(() -> new RuntimeException("user can be null"));
    }

    private UserResponse convertToResponse(Optional<User> user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.get().getEmail());
        userResponse.setId(user.get().getId());

        if (user.get().getRole().equals(Role.Warrior))
            userResponse.setUsername(user.get().getWarrior().getUsername());
        Map<String, Object> extraClaims = new HashMap<>();

        String token = jwtService.generateToken(extraClaims, user.get());
        userResponse.setToken(token);

        return userResponse;
    }
}
