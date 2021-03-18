package com.example.ordemservico.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ordemservico.dtos.OrdemServicoDTO;
import com.example.ordemservico.entities.OrdemServico;
import com.example.ordemservico.services.OrdemServicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/ordemservico")
@Api(value = "API REST Ordem de Serviço")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class OrdemServicoController {
	
	private final OrdemServicoService ordemServicoService;
	
	

	@PostMapping
	@ApiOperation(value = "Cadastra uma ordem de servico")
	public ResponseEntity<Void> cadatrarOrdemServico(@Valid @RequestBody OrdemServicoDTO ordemServicoDTO){
		OrdemServico ordemServico =  ordemServicoService.insert(ordemServicoDTO);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(ordemServico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todas as ordens de serviço")
	public ResponseEntity<List<OrdemServicoDTO>> buscarTodasOrdemServico(){
		List<OrdemServicoDTO> list = ordemServicoService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Busca uma ordem de serviço por id")
	public ResponseEntity<OrdemServicoDTO> buscarOrdemServicoPorId(@PathVariable int id){
		 OrdemServicoDTO ordemServico = ordemServicoService.findById(id);
		 return ResponseEntity.ok().body(ordemServico);
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "Remove uma ordem de serviço por id")
	public ResponseEntity<Void> deletarOrdermServico(@PathVariable int id){
		ordemServicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
