package com.example.demo.mainnn.Models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(schema = "desafio", name = "jogos")
@Getter
@Setter

public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "desenvolvedor")
    private String desenvolvedor;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_de_lancamento")
    private LocalDate dataDeLancamento;

}