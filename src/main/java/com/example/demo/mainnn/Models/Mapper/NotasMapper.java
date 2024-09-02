package com.example.demo.mainnn.Models.Mapper;

import com.example.demo.mainnn.Models.Models.Jogos.JogosInput;
import com.example.demo.mainnn.Models.Models.Notas.NotasInput;
import com.example.demo.mainnn.Models.Models.Notas.NotasMedia;
import com.example.demo.mainnn.Models.Models.Notas.NotasModel;
import com.example.demo.mainnn.Models.entities.Jogos;
import com.example.demo.mainnn.Models.entities.Notas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class NotasMapper {

    @Mapping(source = "id.idJogos", target = "idJogos")
    @Mapping(source = "id.idPessoas", target = "idPessoas")
    public abstract NotasModel notasToModel(Notas notas);

    @Mapping(source = "id.idJogos", target = "idJogos")
    @Mapping(source = "id.idPessoas", target = "idPessoas")
    public abstract NotasModel notasToNotasModel(Notas notas);

    @Mapping(source = "id.idJogos", target = "idJogos")
    public abstract NotasMedia notasToNotasMedia(Notas notas);

    @Mapping(source = "idJogos", target = "id.idJogos")
    @Mapping(source = "idPessoas", target = "id.idPessoas")
    public abstract Notas notasImputParaNotas(NotasInput input);

    @Mapping(target = "id", ignore = true)
    public abstract void updateNotas (@MappingTarget Notas notas, NotasInput input);

}
