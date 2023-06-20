package com.edu.ifmg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.ifmg.domain.model.Transacao;

@Repository
public interface TransacaoRepository extends
JpaRepository<Transacao, Long>{
	

	
	
}