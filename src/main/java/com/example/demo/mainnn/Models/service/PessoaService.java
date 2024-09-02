package com.example.demo.mainnn.Models.service;

import com.example.demo.mainnn.Models.Mapper.PessoaMapper;
import com.example.demo.mainnn.Models.Models.Pessoas.PessoaInput;
import com.example.demo.mainnn.Models.Models.Pessoas.PessoasModel;
import com.example.demo.mainnn.Models.entities.Pessoa;
import com.example.demo.mainnn.Models.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    private static final Logger log = LoggerFactory.getLogger(PessoaService.class);
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaMapper pessoasMapper;
    @Transactional
    public List<PessoasModel> listarPessoa(){

        log.info("começou a tentar a listar(sem model)");

        List<Pessoa> lista = pessoaRepository.findAll();

        List<PessoasModel> lista2 = new ArrayList<>();
        for(Pessoa pessoa: lista) {
            lista2.add(pessoasMapper.pessoaToModel(pessoa));
        }

        log.info("listou");
        return lista2;
    }

    @Transactional
    public PessoasModel obeterPessoa(int id){
        log.info("começou a a tentar listar por id");

        Pessoa pessoa = pessoaRepository.obterPessoa(id);

        PessoasModel pessoaModel = pessoasMapper.pessoaToModel(pessoa);

        log.info("livro por id obtido");

        return pessoaModel;
    }

    @Transactional
    public PessoasModel pessoaSalvar(PessoaInput imput){
        log.info("Tentando salvar um jogo");

        Pessoa pessoa = pessoasMapper.pessoaImputToPessoa(imput);

        Pessoa pessoa2 = pessoaRepository.save(pessoa);

        PessoasModel pessoaModel = pessoasMapper.pessoaToModel(pessoa2);

        log.info("deve ter conseguido salvar");

        return pessoaModel;

    }

    public void deletarJogo(int id) {
        log.info("tentando apagar");

        pessoaRepository.deleteById(id);

        log.info("provavelmente conseguiu");
    }

    @Transactional
    public PessoasModel atualizarPessoa(int id, PessoaInput imput) throws Exception {
        log.info("tentando atualiza");

        Pessoa pessoa = pessoaRepository.obterPessoa(id);

        if(pessoa == null){
            throw new Exception ("Não existe uma pessoa com essse id(provavelmente)");
        }

        pessoasMapper.updatePessoa(pessoa, imput);

        log.info("Atualizado com sucesso");

        PessoasModel pessoa2 = pessoasMapper.pessoaToModel(pessoaRepository.save(pessoa));

        return pessoa2;
    }


}
