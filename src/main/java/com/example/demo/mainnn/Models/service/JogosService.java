package com.example.demo.mainnn.Models.service;

import com.example.demo.mainnn.Models.Mapper.JogosMapper;
import com.example.demo.mainnn.Models.Models.Jogos.JogosModel;
import com.example.demo.mainnn.Models.entities.Jogos;
import com.example.demo.mainnn.Models.Models.Jogos.JogosInput;
import com.example.demo.mainnn.Models.repositories.JogosRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogosService {

    private static final Logger log = LoggerFactory.getLogger(JogosService.class);
    @Autowired
    JogosRepository jogosRepository;

    @Autowired
    JogosMapper jogosMapper;

    @Transactional
    public List<JogosModel> listarJogosModel(){

        log.info("começou a tentar a listar(sem model)");

        List<Jogos> lista = jogosRepository.findAll();

        List<JogosModel> lista2 = new ArrayList<>();
        for(Jogos jogos: lista) {
            lista2.add(jogosMapper.jogosToJogosModel(jogos));
        }

        log.info("listou");

        return lista2;
    }

    @Transactional
    public Jogos obeterJogos(int id){
        log.info("começou a a tentar listar por id");

        Jogos jogo1 = jogosRepository.obterJogos(id);

        log.info("livro por id obtido");

        return jogo1;
    }

    @Transactional
    public Jogos jogosSalvar(JogosInput imput){
        log.info("Tentando salvar um jogo");

        Jogos jogo1 = jogosMapper.jogosImputParaJogos(imput);

        Jogos jogo2 = jogosRepository.save(jogo1);

        log.info("deve ter conseguido salvar");

        return jogo2;

    }

    @Transactional
    public JogosModel autualizarJogo(int id, JogosInput imput) throws Exception {
        log.info("tentando atualiza");

        Jogos jogos = jogosRepository.obterJogos(id);

        if(jogos == null){
            throw new Exception ("Não existe um jogo com essse id(provavelmente)");
        }

        jogosMapper.updateJogo(jogos, imput);

        log.info("Atualizado com sucesso");

        JogosModel jogos2 = jogosMapper.jogosToJogosModel(jogosRepository.save(jogos));

        return jogos2;
    }

    public void deletarJogo(int id) {

        jogosRepository.deleteById(id);
    }
}
