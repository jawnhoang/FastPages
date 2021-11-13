package edu.sjsu.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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




}
