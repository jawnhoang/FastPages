package edu.sjsu.project.books;

import edu.sjsu.project.department.Department;
import edu.sjsu.project.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*basically makes it Primary key*/
    private Integer id;

    @Column(nullable = false, length = 64)
    private String title;

    @Column(nullable = false)
    private int year;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookDetails> details = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Book() {
    }

    public Book(Integer id){
        this.id = id;
    }

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }


    /***
     * getters and setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addAuth(String firstName, String lastName){
        this.details.add(new BookDetails(firstName, lastName, this));
    }

    public List<BookDetails> getDetails() {
        return details;
    }

    public void setDetails(List<BookDetails> details) {
        this.details = details;
    }

    public void setDetails(Integer id, String firstName, String lastName){
        this.details.add(new BookDetails(id, firstName, lastName, this));
    }

}

