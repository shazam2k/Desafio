package com.example.demo.mainnn.Models.repositories;

import com.example.demo.mainnn.Models.entities.Notas;
import com.example.demo.mainnn.Models.entities.PK.PKNotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasRepository extends JpaRepository<Notas, PKNotas> {

    @Query("Select l from Notas l WHERE l.id = :pkNotas")
    Notas obterNotas(PKNotas pkNotas);

    @Query("Select l from Notas l WHERE l.id.idJogos = :idJogos")
    List<Notas> obterNotasJogo(int idJogos);

    @Query("Select sum(n.nota) from Notas n WHERE n.id.idJogos = :idJogos")
    Double obterNotasSomadas(int idJogos);

    @Query("Select count(n.nota) from Notas n WHERE n.id.idJogos = :idJogos")
    Integer obterNotasContadas(int idJogos);

}
