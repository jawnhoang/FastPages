package edu.sjsu.project.app;


import edu.sjsu.project.books.Book;
import edu.sjsu.project.books.BookRepository;
import edu.sjsu.project.user.User;
import edu.sjsu.project.user.UserRepository;
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
public class AppController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

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

    @GetMapping("/home")
    public String viewUsersList(){
        return "home";
    }


    @GetMapping("/sell")
    public String sellBookForm(Model model){
        //create new book object to push to db
        model.addAttribute("book", new Book());

        return "book_form";
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
