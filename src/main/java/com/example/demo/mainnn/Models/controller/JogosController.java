package com.example.demo.mainnn.Models.controller;

import com.example.demo.mainnn.Models.Models.Jogos.JogosInput;
import com.example.demo.mainnn.Models.Models.Jogos.JogosModel;
import com.example.demo.mainnn.Models.entities.Jogos;
import com.example.demo.mainnn.Models.service.JogosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jogos")
public class JogosController {

    @Autowired
    private JogosService jogosService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<JogosModel> lista() {

        System.out.println("ta aqui");

        return jogosService.listarJogosModel();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Jogos jogoPorId(@PathVariable int id){

        return jogosService.obeterJogos(id);
    }

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Jogos jogosSalvar(@RequestBody JogosInput input){

        return jogosService.jogosSalvar(input);
    }
//    {
//        "id": 5,
//            "titulo": "Em guarda",
//            "descricao": "Livro sobre apologetica",
//            "autor": "Craig",
//            "dataEmprestimo": "2001-06-28",
//            "paginas": 200,
//            "quantidade": 100
//    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarJogos(@PathVariable int id){
        jogosService.deletarJogo(id);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public JogosModel autalizarJogo (@PathVariable int id, @RequestBody JogosInput input) throws Exception{
        return jogosService.autualizarJogo(id, input);

    }
    // Chave estrangeira: muitos pra muitos
    // criar outrar tabel: relaciona id jogos a id pessoa e nota
    // nova tabela que relaciona as duas outras
    // tirar notas de pessoas
    // id nota(pk) e id jogos(forgein key) e id pessoas(forgein key) + nota
    // if spring
    // se a pessoa ja tiver dado nota atualiza


    // TESTEEEEEEEEEE

}