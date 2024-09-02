package com.example.demo.mainnn.Models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "desafio", name = "pessoa")
@Getter
@Setter

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @Column(name = "nome")
    private String nome;

}
