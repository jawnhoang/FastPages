package edu.sjsu.project.app;

import edu.sjsu.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


/***
 * handles mapping of all html and redirects
 */
@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/profile")
    public String viewProfilePage() {return "profile"; }

    @GetMapping("/home")
    public String viewUsersList(){
        return "home";
    }

    //manually navigate to /adminHome when logged in as the admin account
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/adminHome")
    public String viewAdminsList(){ return "adminHome"; }

}
