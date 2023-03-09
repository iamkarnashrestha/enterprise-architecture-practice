package com.example.lab8partchsql.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="personId")
    List<Pet> pets;

    public Person(){}
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Person(String firstName, String lastName, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }
}
