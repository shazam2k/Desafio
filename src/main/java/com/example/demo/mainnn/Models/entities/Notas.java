package com.example.demo.mainnn.Models.entities;

import com.example.demo.mainnn.Models.entities.PK.PKNotas;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "desafio", name = "notas")
@Getter
@Setter

public class Notas {

    @EmbeddedId
    private PKNotas id;

    @Column(name = "nota")
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "id_jogos", referencedColumnName = "id", insertable = false, updatable = false)
    private Jogos jogo;

    @ManyToOne
    @JoinColumn(name = "id_pessoas", referencedColumnName = "id", insertable = false, updatable = false)
    private Pessoa pessoa;

}
