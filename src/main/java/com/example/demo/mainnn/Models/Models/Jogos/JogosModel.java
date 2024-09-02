package com.example.demo.mainnn.Models.Models.Jogos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JogosModel {

    private int id;

    private String titulo;

    private String descricao;

    private String desenvolvedor;

    private int valor;

    private String dataDeLancamento;

}
