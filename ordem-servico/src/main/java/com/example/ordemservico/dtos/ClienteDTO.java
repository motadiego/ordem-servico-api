package com.example.ordemservico.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteDTO implements Serializable  {

	private static final long serialVersionUID = 1L;

	private int id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5 , max=20 , message="O tamanho deve ser entre 5 e 20 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="E-mail inválido")
	private String email;
	
	private String telefone;
	
	private String cpf;
}
