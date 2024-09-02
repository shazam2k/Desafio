package com.example.demo.mainnn.Models.controller;

import com.example.demo.mainnn.Models.Models.Jogos.JogosInput;
import com.example.demo.mainnn.Models.Models.Jogos.JogosModel;
import com.example.demo.mainnn.Models.Models.Notas.NotasInput;
import com.example.demo.mainnn.Models.Models.Notas.NotasMedia;
import com.example.demo.mainnn.Models.Models.Notas.NotasModel;
import com.example.demo.mainnn.Models.entities.Notas;
import com.example.demo.mainnn.Models.service.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Notas")

public class NotasController {

    @Autowired
    private NotasService notasService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<NotasModel> lista() {

        System.out.println("ta aqui");

        return notasService.listarNotas();
    }

    @GetMapping("/{idJogos}/{idPessoa}")
    @ResponseStatus(HttpStatus.OK)
    public NotasModel notasPorId(@PathVariable int idJogos, @PathVariable int idPessoa){

        return notasService.obterNotas(idJogos, idPessoa);
    }


    @GetMapping("/notas/{idJogos}")
    @ResponseStatus(HttpStatus.OK)
    public NotasMedia obterNotaMedia (@PathVariable int idJogos){

        return notasService.obterNotaMedia(idJogos);
    }

    @DeleteMapping("/deletar/{idJogos}/{idPessoa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarNotas(@PathVariable int idJogos, @PathVariable int idPessoa){
        notasService.deletarNotas(idJogos, idPessoa);
    }

    @PutMapping("/editar/{idJogos}/{idPessoa}")
    @ResponseStatus(HttpStatus.CREATED)
    public NotasModel atualiazarNotas (@PathVariable int idJogos, @PathVariable int idPessoa,
                                     @RequestBody NotasInput input) throws Exception{

        return notasService.autualizarNota(idJogos, idPessoa, input);

    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Notas notasSalvar(@RequestBody NotasInput input){

        return notasService.notasSalvar(input);
    }

}
