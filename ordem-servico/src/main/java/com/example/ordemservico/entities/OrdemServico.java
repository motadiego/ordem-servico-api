package com.example.ordemservico.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.ordemservico.enums.StatusOrdemServico;

import lombok.Data;

@Data
@Entity
@Table(name="tb_ordem_servico")
public class OrdemServico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ordem_servico")
	private Integer id;
	
	private String descricao;
	
	private BigDecimal preco;
	
	private LocalDateTime dataAbertura;
	
	private LocalDateTime dataFinalizacao;
	
	private StatusOrdemServico status;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Comentario> comentarios;
	
}
