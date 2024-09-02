package com.example.demo.mainnn.Models.Mapper;

import com.example.demo.mainnn.Models.Models.Jogos.JogosInput;
import com.example.demo.mainnn.Models.Models.Jogos.JogosModel;
import com.example.demo.mainnn.Models.entities.Jogos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class JogosMapper {
    public abstract Jogos jogosImputParaJogos(JogosInput input);

    public abstract JogosModel jogosToJogosModel(Jogos jogos);

    @Mapping(target = "id", ignore = true)
    public abstract void updateJogo (@MappingTarget Jogos jogo, JogosInput imput); // @mappingTarget: used to indicate that the target parameter is an existing instance that should be updated or modified, rather than creating a new instance.


}