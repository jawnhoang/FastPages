package edu.sjsu.project.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/***
 * handles mapping of all html and redirects
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;


    @GetMapping("/register")
    public String registerForm(Model model){
        //create new user object to send to form
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_registration")
    public String processRegistration(User user){ //pass input field handler
        /**
         * encrypts password and saves it to DB
         */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String cryptPass = encoder.encode(user.getPassword());
        user.setPassword(cryptPass);
        userRepo.save(user);
        return "registration_success";

    }


    @GetMapping("/login")
    public String loginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //check to see if a visitor is logged in
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/";
    }
}
