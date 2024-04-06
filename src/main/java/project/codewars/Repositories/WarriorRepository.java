package project.codewars.Repositories;

import project.codewars.entity.Warrior;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarriorRepository extends JpaRepository<Warrior, Long> {
}
