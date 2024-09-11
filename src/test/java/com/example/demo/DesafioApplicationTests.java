package com.example.demo;

import com.example.demo.mainnn.Models.Aplication;
import com.example.demo.mainnn.Models.Mapper.JogosMapper;
import com.example.demo.mainnn.Models.Mapper.NotasMapper;
import com.example.demo.mainnn.Models.Models.Jogos.JogosModel;
import com.example.demo.mainnn.Models.entities.Jogos;
import com.example.demo.mainnn.Models.entities.Notas;
import com.example.demo.mainnn.Models.repositories.JogosRepository;
import com.example.demo.mainnn.Models.repositories.NotasRepository;
import com.example.demo.mainnn.Models.service.JogosService;
import com.example.demo.mainnn.Models.service.NotasService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Aplication.class)
class DesafioApplicationTests {

	@InjectMocks
	JogosService jogosService;

	@Mock
	JogosMapper jogosMapper;

	@Mock
	JogosRepository jogosRepository;

	@Test
	void listarJogos(){

		Mockito.when(jogosRepository.findAll()).thenReturn(mockJogosLista());

		List<JogosModel> jogos = jogosService.listarJogosModel();

		assertEquals(jogos.size(), mockJogosLista().size());
	}


	public List<Jogos> mockJogosLista(){
		Jogos jogos = new Jogos();

		jogos.setId(1);
		jogos.setTitulo("Minecraft");
		jogos.setDescricao("Melhor jogo já feito por mãos humanas");

		return Collections.singletonList(jogos);
	}
}
