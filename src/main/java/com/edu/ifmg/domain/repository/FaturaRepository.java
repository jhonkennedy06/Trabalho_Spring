package com.edu.ifmg.domain.repository;

import com.edu.ifmg.domain.model.Categoria;
import com.edu.ifmg.domain.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.edu.ifmg.domain.model.Transacao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    List<Fatura> findByCategoria(Categoria categoria);
    //exemplo localhost:8080/fatura?Lazer


}
