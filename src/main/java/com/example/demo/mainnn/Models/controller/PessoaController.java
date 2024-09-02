package com.example.demo.mainnn.Models.controller;

import com.example.demo.mainnn.Models.Models.Pessoas.PessoaInput;
import com.example.demo.mainnn.Models.Models.Pessoas.PessoasModel;
import com.example.demo.mainnn.Models.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pessoa")

public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<PessoasModel> lista() {

        System.out.println("ta aqui");

        return pessoaService.listarPessoa();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoasModel pessoaPorId(@PathVariable int id){

        return pessoaService.obeterPessoa(id);
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoasModel jogosSalvar(@RequestBody PessoaInput imput){

        return pessoaService.pessoaSalvar(imput);
    }


    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarJogos(@PathVariable int id){
        pessoaService.deletarJogo(id);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoasModel autalizarPessoa (@PathVariable int id, @RequestBody PessoaInput input) throws Exception{
        return pessoaService.atualizarPessoa(id, input);

    }
}
