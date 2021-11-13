package edu.sjsu.project.cart;


import edu.sjsu.project.user.CustomUserDetails;
import edu.sjsu.project.user.User;
import edu.sjsu.project.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartServices cartServices;

    @Autowired CartRepository cartRepo;


    @GetMapping("/cart")
    public String showCart(Model model, @AuthenticationPrincipal Authentication auth){
        //User user = UserService.getCurrentlyLoggedInUser(auth);
        //return list of cart items
       //List<Cart> listCart = cartServices.listCartItems(user);
        /**
         * TODO:
         *  print only book that user checks out.
         *  View cart_items table to see what book_id
         *  is associated with user_id.
         *  Find way to print only books pertaining to
         *  logged in user_id.
         *  This code prints all books in cart_items table.
         */
        List<Cart> listCart = cartRepo.findAll();
        model.addAttribute("listCart", listCart);
        model.addAttribute("pageTitle", "Checked Out Books");

        return "cart";
    }



}
