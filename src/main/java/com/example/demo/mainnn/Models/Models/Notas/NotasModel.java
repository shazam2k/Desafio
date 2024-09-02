package com.example.demo.mainnn.Models.Models.Notas;

import com.example.demo.mainnn.Models.entities.Jogos;
import com.example.demo.mainnn.Models.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotasModel {

    private int idJogos;

    private int idPessoas;

    private double nota;
}
