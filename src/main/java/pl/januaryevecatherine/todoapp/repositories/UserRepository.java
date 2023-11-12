package pl.januaryevecatherine.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.januaryevecatherine.todoapp.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
