package edu.sjsu.project.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>{

    /**
     * find user by email
     */
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findEmail(String email);
}
