package com.swcompany.company.entities;

import javax.persistence.*;

@Entity
@Table(name = "genders")
public class Gender {

    private Integer id;
    private String name;

    public Gender() { }

    public Gender(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
