package com.edu.ifmg.domain.model;



import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private int parcela;

    @Column(nullable = false, columnDefinition = "datetime") // informa que o campo é not null
    private LocalDateTime dataPagamento;

    @Column(nullable = false, columnDefinition = "datetime") // informa que o campo é not null
    private LocalDateTime dataVencimento;

    /* campo para o fatura id */
    @ManyToOne
    @JoinColumn(name = "fatura_id", nullable = false)
    private Fatura fatura;

}
