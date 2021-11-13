/*
package edu.sjsu.project.books;

import edu.sjsu.project.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServices {

    @Autowired
    private CartItemRepository cartRepo;

    public List<CartItem> listCartItems(User u){
        return cartRepo.findByUser(u);
    }

}
*/