package project.codewars.Repositories;

import project.codewars.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

    Optional<Tasks> findByName(String name);
}
