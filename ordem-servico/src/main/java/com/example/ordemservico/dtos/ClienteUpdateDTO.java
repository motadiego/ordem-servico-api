package com.example.ordemservico.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteUpdateDTO implements Serializable  {

	private static final long serialVersionUID = 1L;

	private int id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5 , max=20 , message="O tamanho deve ser entre 5 e 20 caracteres")
	private String nome;
	
	private String telefone;
}
