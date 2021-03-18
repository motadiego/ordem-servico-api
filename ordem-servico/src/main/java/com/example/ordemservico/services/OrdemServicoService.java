package com.example.ordemservico.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.ordemservico.dtos.ClienteDTO;
import com.example.ordemservico.dtos.ComentarioDTO;
import com.example.ordemservico.dtos.OrdemServicoDTO;
import com.example.ordemservico.entities.Comentario;
import com.example.ordemservico.entities.OrdemServico;
import com.example.ordemservico.exceptions.DataIntegrationException;
import com.example.ordemservico.exceptions.EntityNotFoundException;
import com.example.ordemservico.repositories.OrdemServicoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OrdemServicoService {

	private final OrdemServicoRepository ordemServicoRepository;
	
	private final ModelMapper mapper;
	
	
	public OrdemServico insert(OrdemServicoDTO ordemServicoDTO) {
		OrdemServico ordemServico = mapper.map(ordemServicoDTO , OrdemServico.class);
		for (Comentario comentario : ordemServico.getComentarios()) {
			comentario.setOrdemServico(ordemServico);
		}
		return ordemServicoRepository.save(ordemServico);
	}
	
	public List<OrdemServicoDTO> findAll() {
		return ordemServicoRepository.findAllByOrderByDataAbertura()
			.stream()
			.map(ordem -> { 
				OrdemServicoDTO ordemServicoDTO =  mapper.map(ordem, OrdemServicoDTO.class); 
				ordemServicoDTO.setCliente( mapper.map(ordem.getCliente(), ClienteDTO.class));
				ordemServicoDTO.setComentarios(new ArrayList<ComentarioDTO>());
				for(Comentario comentario : ordem.getComentarios()) {
					ComentarioDTO comentarioDTO = mapper.map(comentario, ComentarioDTO.class);
					ordemServicoDTO.getComentarios().add(comentarioDTO);
				}
				return ordemServicoDTO;
			}).collect(Collectors.toList());
	}
	
	
	public OrdemServicoDTO findById(int id) {
		OrdemServico ordemServico = find(id);
		return mapper.map(ordemServico , OrdemServicoDTO.class);
	}
	
	public void delete(int id) {
		try {
			OrdemServico ordemServico  = find(id);
			ordemServicoRepository.delete(ordemServico);
		} catch (DataIntegrationException  e) {
			throw new DataIntegrationException("Não é possível excluir uma orderm de serviço que possui dados associados");
		}
	}
	
	
	private OrdemServico find(int id) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);

		if(!ordemServico.isPresent()) {
			throw new EntityNotFoundException("Ordem de serviço de id " + id + " não encontrado!");
		}
		
		return ordemServico.get();
	}

}
