package edu.sjsu.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    public void saveUserWithDefRole(User u){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String cryptPass = encoder.encode(u.getPassword());
        u.setPassword(cryptPass);

        Role roleUser = roleRepo.findByName("User");
        u.addRole(roleUser);

        userRepo.save(u);
    }

    public List<User> listAll(){
        return userRepo.findAll();
    }
}
 */
