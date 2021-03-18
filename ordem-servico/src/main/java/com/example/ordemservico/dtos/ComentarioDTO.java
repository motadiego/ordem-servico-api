package com.example.ordemservico.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.ordemservico.entities.OrdemServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime dataEnvio;
	
	@JsonIgnore
	private OrdemServico ordemServico;
}
