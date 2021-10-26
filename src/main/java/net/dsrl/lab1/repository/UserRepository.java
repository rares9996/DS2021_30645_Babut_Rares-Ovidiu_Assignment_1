package net.dsrl.lab1.repository;

import net.dsrl.lab1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByName(String username);

  Boolean existsByUsername(String username);

  Integer deleteByUsername(String username);
}
