package com.example.demo.mainnn.Models.Models.Jogos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class JogosInput {

    private int id;

    private String titulo;

    private String descricao;

    private String desenvolvedor;

    private double valor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeLancamento;

}
