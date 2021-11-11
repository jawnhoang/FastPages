package edu.sjsu.project.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public static User getCurrentlyLoggedInUser(Authentication auth){
        if(auth == null){
            return null;
        }
        User user = null;
        Object principal = auth.getPrincipal();
        if(principal instanceof CustomUserDetails){
            user = ((CustomUserDetails) principal).getUser();
        }
        return user;
    }








    /*
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
*/
}
