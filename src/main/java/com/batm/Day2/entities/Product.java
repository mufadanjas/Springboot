package com.batm.Day2.entities;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
    private String Name;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Category getCategory() {return category;}

    public void setCategory(Category category){this.category = category;}
}
