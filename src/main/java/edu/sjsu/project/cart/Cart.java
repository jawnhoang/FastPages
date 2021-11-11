/*
package edu.sjsu.project.cart;

import edu.sjsu.project.books.Book;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "book_id")
    private Long bookId;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;

    private int quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setbookId(Long bookId) {
        this.bookId = bookId;
    }

    public Book getProduct() {
        return book;
    }

    public void setBook(Book b) {
        this.book = b;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

 */
