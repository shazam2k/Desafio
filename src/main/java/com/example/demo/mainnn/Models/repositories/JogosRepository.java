package com.example.demo.mainnn.Models.repositories;

import com.example.demo.mainnn.Models.entities.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Integer> {

    @Query("Select l from Jogos l WHERE l.id = :id")
    Jogos obterJogos(int id);

    @Query("Select titulo from Jogos j WHERE j.id = :idJogos")
    String obterNome(int idJogos);

}

