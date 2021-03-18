package com.example.ordemservico.controllers;


import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.example.ordemservico.dtos.ClienteDTO;
import com.example.ordemservico.services.ClienteService;
import com.example.ordemservico.services.OrdemServicoService;

import io.restassured.http.ContentType;

@WebMvcTest
class ClienteControllerTest {

	@Autowired
	private ClienteController clienteController;
	
	@MockBean
	private ClienteService clienteService;
	
	@MockBean
	private OrdemServicoService ordemServicoService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.clienteController);
	}
	
	@Test
	void deveRetornarSucesso_QuandoBuscarCliente() {
		
		when(this.clienteService.findById(1))
		  .thenReturn(ClienteDTO.builder().id(1).build());
		
		given().
			accept(ContentType.JSON)
		.when()
			.get("/api/clientes/{id}" , 1)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	
	@Test
	void deveRetornarNaoEncontado_QuandoBuscarCliente() {
		
		when(this.clienteService.findById(5))
		  .thenReturn(null);
		
		given().
			accept(ContentType.JSON)
		.when()
			.get("/api/clientes/{id}" , 5)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}


}
