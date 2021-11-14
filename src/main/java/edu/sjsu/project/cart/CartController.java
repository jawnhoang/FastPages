package edu.sjsu.project.cart;


import edu.sjsu.project.books.Book;
import edu.sjsu.project.books.BookDetails;
import edu.sjsu.project.books.BookRepository;
import edu.sjsu.project.user.CustomUserDetails;
import edu.sjsu.project.user.User;
import edu.sjsu.project.user.UserRepository;
import edu.sjsu.project.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CartServices cartServices;

    @Autowired
    private BookRepository bookRepo;

    @Autowired CartRepository cartRepo;

    @GetMapping("/cart")
    public String showCart(Model model){

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
        User user;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if(principal instanceof CustomUserDetails){
            user = ((CustomUserDetails) principal).getUser();
        } else {
            user = null;
        }

        List<Cart> cartItems = cartServices.listCartItems(user);
        model.addAttribute("listCart", cartItems);
        model.addAttribute("pageTitle", "Checked Out Books");

        return "cart";
    }

    @GetMapping("/adminPanel")
    public String showAdminPage(Model model, @AuthenticationPrincipal Authentication auth){

        List<Cart> listCart = cartRepo.findAll();
        model.addAttribute("listCart", listCart);
        model.addAttribute("pageTitle", "All Checked Out Books");

        return "admin_panel";
    }

    @GetMapping("/cart/add/{id}")
    public String getCartItems(@PathVariable("id") Integer id, Model model){
        Book book = bookRepo.findById(id).get();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Cart> listCart = cartRepo.findAll();
        User user;
        Object principal = auth.getPrincipal();
        if(principal instanceof CustomUserDetails){
            user = ((CustomUserDetails) principal).getUser();
        } else {
            user = null;
        }

        cartServices.addBook(book.getId(), user);

        model.addAttribute("book", book);
        return "cart_form";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeCartItem(@PathVariable("id") Integer id, Model model){
        Book book = bookRepo.findById(id).get();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Cart> listCart = cartRepo.findAll();
        User user;
        Object principal = auth.getPrincipal();
        if(principal instanceof CustomUserDetails){
            user = ((CustomUserDetails) principal).getUser();
        } else {
            user = null;
        }

        cartServices.removeBook(book.getId(), user);

        model.addAttribute("book", book);
        return "remove_cart";
    }


}
