package com.example.demo.mainnn.Models.Mapper;

import com.example.demo.mainnn.Models.Models.Pessoas.PessoaInput;
import com.example.demo.mainnn.Models.Models.Pessoas.PessoasModel;
import com.example.demo.mainnn.Models.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class PessoaMapper {
    public abstract PessoasModel pessoaToModel(Pessoa pessoa);

    public abstract Pessoa pessoaImputToPessoa(PessoaInput input);

    @Mapping(target = "id", ignore = true)
    public abstract void updatePessoa (@MappingTarget Pessoa pessoa, PessoaInput imput);
}
