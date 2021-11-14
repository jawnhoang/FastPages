package edu.sjsu.project.cart;


import edu.sjsu.project.books.Book;
import edu.sjsu.project.books.BookRepository;
import edu.sjsu.project.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CartServices {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private BookRepository bookRepo;

    public List<Cart> listCartItems(User user){
        return cartRepo.findByUser(user);
    }

    public Integer addBook(Integer bookId, User u){
        Integer totalAdded = 1;

        Book book = bookRepo.findById(bookId).get();

        Cart cart = cartRepo.findByUserAndBook(u, book);

        if(cart != null){
            totalAdded = cart.getQuantity() + 1;
            cart.setQuantity(totalAdded);
        } else {
            cart = new Cart();
            cart.setQuantity(1);
            cart.setUser(u);
            cart.setBook(book);
        }

        cartRepo.save(cart);

        return totalAdded;
    }

    public Integer removeBook(Integer bookId, User u){
        Integer totalAdded = 0;

        Book book = bookRepo.findById(bookId).get();
        Cart cart = cartRepo.findByUserAndBook(u, book);
        //List<Cart> allCarts = cartRepo.findAll();

        cartRepo.deleteById(cart.getId());

        /*
        if(cart != null) {
            allCarts.remove(cart);
            //cartRepo.save(cart);
        }

        cartRepo.save(cart);
         */
        return totalAdded;
    }
}

