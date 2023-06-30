package com.edu.ifmg.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false) // informa que o campo é not null
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<MetaCategoria> metasCategoria = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Fatura> faturas = new ArrayList<>();

}
