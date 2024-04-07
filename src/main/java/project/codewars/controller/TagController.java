package project.codewars.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.codewars.Service.TagService;

@RestController
@AllArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping("/addtag")
    public void addtag(@RequestParam String name, @RequestHeader ("Authorization") String token) {
        tagService.addtag(name, token);
    }
}
