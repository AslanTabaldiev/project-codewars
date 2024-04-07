package project.codewars.Repositories;

import org.springframework.stereotype.Repository;
import project.codewars.entity.Warrior;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface WarriorRepository extends JpaRepository<Warrior, Long> {
}
