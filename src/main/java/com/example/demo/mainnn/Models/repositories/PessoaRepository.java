package com.example.demo.mainnn.Models.repositories;

import com.example.demo.mainnn.Models.entities.Jogos;
import com.example.demo.mainnn.Models.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("Select l from Pessoa l WHERE l.id = :id")
    public Pessoa obterPessoa(int id);

}
