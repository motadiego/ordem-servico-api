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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ordemservico.dtos.ClienteDTO;
import com.example.ordemservico.dtos.ClienteUpdateDTO;
import com.example.ordemservico.entities.Cliente;
import com.example.ordemservico.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/clientes")
@Api(value = "API REST Clientes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;
	
	
	@PostMapping
	@ApiOperation(value = "Insere um cliente")
	public ResponseEntity<Void> inserirCliente(@Valid @RequestBody ClienteDTO clienteDTO){
		Cliente cliente = clienteService.insert(clienteDTO);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todos os clientes")
	public ResponseEntity<List<ClienteDTO>> buscarTodosClientes(){
		List<ClienteDTO> list = clienteService.findAll();
		
		if(list == null){
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um cliente por id")
	public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable int id){
		ClienteDTO cliente =  clienteService.findById(id);
		
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok().body(cliente);
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um cliente")
	public ResponseEntity<ClienteUpdateDTO> atualizarCliente(@Valid @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
		clienteService.update(clienteUpdateDTO);
		return ResponseEntity.noContent().build();
	}

	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um cliente")
	public ResponseEntity<Void> deletarCliente(@PathVariable int id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
