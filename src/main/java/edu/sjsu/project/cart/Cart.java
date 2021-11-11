package edu.sjsu.project.cart;


import edu.sjsu.project.books.Book;
import edu.sjsu.project.user.User;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //reference to books user will check out
    //cart can contain a book item 1 or more times
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    //user can choose 1 or more books to cart
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private  int quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
