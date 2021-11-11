/*
package edu.sjsu.project.books;

import javax.persistence.*;
import edu.sjsu.project.user.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User u;

    private int quantity;

    public Integer getID(){
        return id;
    }

    public void setID(Integer id){
        this.id = id;
    }


    public Book getBook(){
        return book;
    }

    public void setBook(Book b){
        this.book = b;
    }

    public User getUser(){
        return u;
    }

    public void setUser(User u){
        this.u = u;
    }



    public int getUser_id(){
        return user_id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q){
        this.quantity = q;
    }

}
*/