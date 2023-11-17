package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="user")
public class User implements Serializable {
    public User(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public  Integer id;
    @Column (name="password")
    public String password;


}
