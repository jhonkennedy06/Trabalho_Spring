package com.edu.ifmg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.ifmg.domain.model.Transacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findBydataBetween(LocalDateTime primeiraData, LocalDateTime segundaData);
    //teste para a funcionalidade de cima localhost:8080/transacao?primeiraData=2023-06-03T00:23:40&segundaData=2023-07-30T23:59:59

    /* Codigo com erro, suspeito ser o nome da variavel, data_pagamento e data_vencimento, talves tirar o traço em tudo e mudar seu nome dê certo
    List<Transacao> findBydata_pagamentoBetween(LocalDateTime data_inicial, LocalDateTime data_final);

    List<Transacao> findBydata_vencimentoBetween(LocalDateTime data_inicial, LocalDateTime data_final);*/

}