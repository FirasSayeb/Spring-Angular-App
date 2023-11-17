package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="Mail")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public  Integer id;
    @Column(name="destinataire")
    public String destinatire;
    @Column(name="objet")
    public String objet;
    @Column(name="message")
    public String message;


    public Mail() {
    }



    public Mail( String destinatire, String objet, String message) {

        this.destinatire = destinatire;
        this.objet = objet;
        this.message = message;
    }
}
