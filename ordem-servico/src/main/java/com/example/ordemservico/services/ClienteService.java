package com.example.ordemservico.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.ordemservico.dtos.ClienteDTO;
import com.example.ordemservico.dtos.ClienteUpdateDTO;
import com.example.ordemservico.entities.Cliente;
import com.example.ordemservico.exceptions.DataIntegrationException;
import com.example.ordemservico.exceptions.EntityAlreadyExistsException;
import com.example.ordemservico.exceptions.EntityNotFoundException;
import com.example.ordemservico.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;
	
	private final ModelMapper mapper;
	
	public Cliente insert(ClienteDTO clienteDTO) {
		verificaSeClienteJaCadastrado(clienteDTO);
		Cliente cli = mapper.map(clienteDTO, Cliente.class);
		return clienteRepository.save(cli);
	}


	private void verificaSeClienteJaCadastrado(ClienteDTO clienteDTO) {
		Optional<Cliente> cliente = clienteRepository.findByCpf(clienteDTO.getCpf());
		
		if(cliente.isPresent()) {
			throw new EntityAlreadyExistsException("Cliente de cpf " + clienteDTO.getCpf() + " já cadastrado!");
		}
		
		cliente = clienteRepository.findByEmail(clienteDTO.getEmail());
		if(cliente.isPresent()) {
			throw new EntityAlreadyExistsException("Cliente de email " + clienteDTO.getEmail() + " já cadastrado!");
		}
	}
	
	
	public List<ClienteDTO> findAll() {
		return clienteRepository.findAll().stream().map(cliente -> {
					ClienteDTO clienteDTO = mapper.map(cliente, ClienteDTO.class);
					clienteDTO.setCpf("");
					return clienteDTO;
				}).sorted(Comparator.comparing(ClienteDTO::getNome)).collect(Collectors.toList());
	}
	
	public ClienteDTO findById(int id){
		Cliente cliente = find(id);
		cliente.setCpf("");
		return mapper.map(cliente, ClienteDTO.class);
	}
	
	public void update(ClienteUpdateDTO clienteUpdateDTO) {
		Cliente cliente  = find(clienteUpdateDTO.getId());
		cliente.setNome(clienteUpdateDTO.getNome());
		clienteRepository.save(cliente);
	}
	
	
	public void delete(int id) {
		try {
			Cliente cliente  = find(id);
			clienteRepository.delete(cliente);
		} catch (Exception  e) {
			throw new DataIntegrationException("Não é possível excluir um cliente que possui ordens de serviço!");
		}
	}
	
	private Cliente find(int id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		if(!cliente.isPresent()) {
			throw new EntityNotFoundException("Cliente de id " + id + " não encontrado!");
		}
		
		return cliente.get();
	}
}
