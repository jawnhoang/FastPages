/*
package edu.sjsu.project.books;

import edu.sjsu.project.user.CustomUserDetailService;
import edu.sjsu.project.user.CustomUserDetails;
import edu.sjsu.project.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartController {

    //@Autowired
    //private CartServices cartService;

    @Autowired
    private CustomUserDetailService userServices;

    @GetMapping("/cart")
    public String showShoppingCart(Model model){
        User u = CustomUserDetails.getUser();
        //List<CartItem> cartItem = cartService.listCartItems(u);

        //model.addAttribute("cartItems", cartItem);
        //model.addAttribute("pageTitle", "Shopping Cart");

        return "shopping_cart";
    }
}
*/