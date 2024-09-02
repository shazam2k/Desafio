package com.example.demo.mainnn.Models.entities.PK;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable

public class PKNotas {

    @Column(name = "id_jogos")
    private int idJogos;

    @Column(name = "id_pessoas")
    private int idPessoas;
}
