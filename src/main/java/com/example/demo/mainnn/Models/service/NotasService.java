package com.example.demo.mainnn.Models.service;

import com.example.demo.mainnn.Models.Mapper.NotasMapper;
import com.example.demo.mainnn.Models.Models.Notas.NotasInput;
import com.example.demo.mainnn.Models.Models.Notas.NotasMedia;
import com.example.demo.mainnn.Models.Models.Notas.NotasModel;
import com.example.demo.mainnn.Models.entities.Jogos;
import com.example.demo.mainnn.Models.entities.Notas;
import com.example.demo.mainnn.Models.entities.PK.PKNotas;
import com.example.demo.mainnn.Models.repositories.JogosRepository;
import com.example.demo.mainnn.Models.repositories.NotasRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotasService {

    private static final Logger log = LoggerFactory.getLogger(NotasService.class);
    @Autowired
    NotasRepository notasRepository;

    @Autowired
    NotasMapper notasMapper;

    @Autowired
    JogosRepository jogosRepository;

    @Transactional
    public List<NotasModel> listarNotas(){

        log.info("começou a tentar a listar(sem model)");

        List<Notas> lista = notasRepository.findAll();

        List<NotasModel> lista2 = new ArrayList<>();
        for(Notas notas : lista) {
            lista2.add(notasMapper.notasToModel(notas));
        }

        log.info("listou");
        return lista2;
    }

    @Transactional
    public NotasModel obterNotas(int idJogos, int idPessoa){
        log.info("começou a a tentar listar por id");
        PKNotas pkNotas = new PKNotas();
        pkNotas.setIdJogos(idJogos);
        pkNotas.setIdPessoas(idPessoa);

        Notas notas1 = notasRepository.findById(pkNotas).get();

        NotasModel notas2 = notasMapper.notasToNotasModel(notas1);

        log.info("nota por id obtido");

        return notas2;
    }


    public void deletarNotas(int idJogos, int idPessoa) {
        PKNotas pkNotas = new PKNotas();
        pkNotas.setIdJogos(idJogos);
        pkNotas.setIdPessoas(idPessoa);

        notasRepository.deleteById(pkNotas);
    }

    @Transactional
    public NotasMedia obterNotaMedia(int idJogos){

        List<Notas> notas = notasRepository.obterNotasJogo(idJogos);

        NotasMedia media = new NotasMedia();

        media.setMedia(notasRepository.obterNotasSomadas(idJogos) / notas.size());

        //Setar o numero do id
        media.setIdJogos(idJogos);

        //Setar o nome do jogo
        media.setNome(jogosRepository.obterNome(idJogos));

        return media;

        //Precisa do @Builder
        //return NotasMedia.builder().media(notasRepository.obterNotasSomadas(idJogos)/notasRepository.obterNotasContadas(idJogos)).idJogos(idJogos).nome(jogosRepository.obterNome(idJogos)).build();
    }

    @Transactional
    public Notas notasSalvar(NotasInput input){
        log.info("Tentando salvar uma notas");

        Notas notas1 = notasMapper.notasImputParaNotas(input);

        Notas notas2 = notasRepository.save(notas1);

        log.info("deve ter conseguido salvar");

        return notas2;

    }

    @Transactional
    public NotasModel autualizarNota(int idJogos, int idPessoa, NotasInput input) throws Exception {
        log.info("tentando atualiza");

        PKNotas pkNotas = new PKNotas();
        pkNotas.setIdJogos(idJogos);
        pkNotas.setIdPessoas(idPessoa);

        Notas notas = notasRepository.obterNotas(pkNotas);

        if(notas == null){
            throw new Exception ("Não existe um jogo com essse id(provavelmente)");
        }

        notasMapper.updateNotas(notas, input);

        log.info("Atualizado com sucesso");

        NotasModel notas2 = notasMapper.notasToNotasModel(notasRepository.save(notas));


        return notas2;
    }


}
