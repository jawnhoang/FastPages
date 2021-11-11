package edu.sjsu.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class   CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findEmail(email);
        if(user == null){
                throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public User getCurrentUser(Authentication auth){
        if(auth == null){
            return null;
        }

        User u = null;
        Object principal = auth.getPrincipal();

        if(principal instanceof CustomUserDetails) {
            u = ((CustomUserDetails) principal).getUser();
        }

        return u;
    }

}
