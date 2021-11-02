package edu.sjsu.project.app;

import edu.sjsu.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

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


    @GetMapping("/home")
    public String viewUsersList(){
        return "home";
    }

}
