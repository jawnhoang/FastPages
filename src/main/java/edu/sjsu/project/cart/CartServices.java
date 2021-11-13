package edu.sjsu.project.cart;


import edu.sjsu.project.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CartServices {

    @Autowired
    private CartRepository cartRepo;


    public List<Cart> listCartItems(User user){
        return cartRepo.findByUser(user);
    }
}

