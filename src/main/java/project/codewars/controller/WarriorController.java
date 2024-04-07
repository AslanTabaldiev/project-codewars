package project.codewars.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import project.codewars.Repositories.WarriorRepository;

@RestController
@AllArgsConstructor
public class WarriorController {

    private final WarriorRepository warriorRepository;

}
