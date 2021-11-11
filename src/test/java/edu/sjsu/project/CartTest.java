package edu.sjsu.project;


import edu.sjsu.project.books.Book;
import edu.sjsu.project.cart.Cart;
import edu.sjsu.project.cart.CartRepository;
import edu.sjsu.project.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CartTest {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private TestEntityManager entityManager;
/***
    @Test
    public void testAddCart(){
        Book book = entityManager.find(Book.class, 4);
        User user = entityManager.find(User.class, 1);

        Cart item = new Cart();
        item.setUser(user);
        item.setBook(book);
        item.setQuantity(1);

        Cart saveCart = cartRepo.save(item);
        assertTrue(saveCart.getId() > 0);
    }




    @Test
    public void testGetCartItems(){
        User user = new User();
        user.setId(1);

        List<Cart> cart = cartRepo.findByUser(user);
        assertEquals(1, cart.size());

    }
*/
}
