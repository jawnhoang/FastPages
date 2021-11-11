package edu.sjsu.project;

import edu.sjsu.project.user.User;
import edu.sjsu.project.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;
/*
    @Test
    public void testCreateUser(){
        /***
         * create user test case

        User user = new User();
        user.setEmail("random5@gmail.com");
        user.setPassword("password");
        user.setFirstName("Kevin");
        user.setLastName("Smith");

        /***
         * saves test case into db

        User savedUser = repo.save(user);

        /***
         * finds if user exists in file

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testEmail(){
        String email = "john.k.hoang@sjsu.edu";
        User user = repo.findEmail(email); //return object found

        assertThat(user).isNotNull(); //return false to indicate user is found
    }
    */

}
