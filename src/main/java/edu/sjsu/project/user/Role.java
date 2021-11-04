package edu.sjsu.project.user;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String name;

    public Role() {}

    public Role(String name){
        this.name = name;
    }

    public Role(String name, int id){
        this.name = name;
        this.id = id;
    }

    public Role(int id){
        this.id = id;
    }

    public String toString(){
        return this.name;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
