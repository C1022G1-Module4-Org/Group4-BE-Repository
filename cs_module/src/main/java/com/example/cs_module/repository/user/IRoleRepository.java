package com.example.cs_module.repository.user;

import com.example.cs_module.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName (String name);
}
