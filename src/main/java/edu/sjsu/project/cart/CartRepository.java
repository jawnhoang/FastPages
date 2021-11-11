package edu.sjsu.project.cart;

import edu.sjsu.project.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    public List<Cart> findByUser(User user);


}
