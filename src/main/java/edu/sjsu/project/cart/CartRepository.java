package edu.sjsu.project.cart;

import edu.sjsu.project.books.Book;
import edu.sjsu.project.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    public List<Cart> findByUser(User user);

    public Cart findByUserAndBook(User user, Book book);

}
