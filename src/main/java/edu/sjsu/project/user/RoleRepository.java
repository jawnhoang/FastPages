package edu.sjsu.project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT u FROM User u WHERE u.name = ?1")
    Role findByName(String name);
}
*/