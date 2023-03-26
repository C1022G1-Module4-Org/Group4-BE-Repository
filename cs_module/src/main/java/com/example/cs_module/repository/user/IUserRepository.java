package com.example.cs_module.repository.user;

import com.example.cs_module.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail (String email);
    Optional<User> findByUsernameOrEmail (String username, String email);
    Optional<User> findByUsername (String username);
    Boolean existsByUsername (String username);
    Boolean existsByEmail (String email);
}
