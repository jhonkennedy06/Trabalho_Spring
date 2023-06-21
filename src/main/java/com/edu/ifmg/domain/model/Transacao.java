package com.edu.ifmg.domain.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity

public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false) // informa que o campo é not null
	private Double valor;

	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime") // informa que o campo é not null
	private LocalDateTime data;

	@Column
	private int parcela;

	@Column(nullable = false, columnDefinition = "datetime") // informa que o campo é not null
	private LocalDateTime data_pagamento;

	@Column(nullable = false, columnDefinition = "datetime") // informa que o campo é not null
	private LocalDateTime data_vencimento;

	/* campo para o fatura id */

}
