package edu.sjsu.project.cart;


import edu.sjsu.project.user.CustomUserDetails;
import edu.sjsu.project.user.User;
import edu.sjsu.project.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartServices cartService;


    @GetMapping("/cart")
    public String showCart(Model model, @AuthenticationPrincipal Authentication auth){
        //User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = UserService.getCurrentlyLoggedInUser(auth);
        //return list of cart items
        List<Cart> listCart = cartService.listCartItems(user);

        model.addAttribute("listCart", listCart);
        model.addAttribute("pageTitle", "Checked Out Books");

        return "cart";
    }


}
