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
    // Retorna uma lista de transações cujas datas estejam entre a primeiraData e a segundaData.

    //teste para a funcionalidade de cima localhost:8080/transacao?primeiraData=2023-06-03T00:23:40&segundaData=2023-07-30T23:59:59

    List<Transacao> findBydataPagamentoBetween(LocalDateTime data_inicial, LocalDateTime data_final);
    // Retorna uma lista de transações cujas datas de pagamento estejam entre a data_inicial e a data_final.

    List<Transacao> findBydataVencimentoBetween(LocalDateTime data_inicial, LocalDateTime data_final);
    // Retorna uma lista de transações cujas datas de vencimento estejam entre a data_inicial e a data_final.

}