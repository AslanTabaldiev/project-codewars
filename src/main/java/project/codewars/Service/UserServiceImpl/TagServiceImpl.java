package project.codewars.Service.UserServiceImpl;

import project.codewars.entity.Tags;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import project.codewars.Repositories.TagRepository;
import project.codewars.Service.TagService;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public void addtag(String name, String token) {
        if(tagRepository.findByName(name).isPresent()) {
            throw new BadCredentialsException("This tag is already exist");
        }
        Tags tags = new Tags();
        tags.setName(name);

        tagRepository.save(tags);
    }
}
