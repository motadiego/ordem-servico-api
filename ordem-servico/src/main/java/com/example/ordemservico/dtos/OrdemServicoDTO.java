package com.example.ordemservico.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.ordemservico.enums.StatusOrdemServico;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemServicoDTO implements Serializable  {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String descricao;
	
	@NotNull(message="Preenchimento obrigatório")
	@DecimalMin(value = "0.0" , message = "Preenchimento obrigatório")
    private BigDecimal preco;
	
	@NotNull(message="Preenchimento obrigatório")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@NotNull(message="Preenchimento obrigatório")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime dataFinalizacao;
	
	@NotNull(message="Preenchimento obrigatório")
	private StatusOrdemServico status;
	
	@NotNull(message="Preenchimento obrigatório")
	private ClienteDTO cliente;
	
	private List<ComentarioDTO> comentarios = new ArrayList<ComentarioDTO>();
	
	
}
