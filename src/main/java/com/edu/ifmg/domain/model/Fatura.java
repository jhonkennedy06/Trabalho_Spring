package com.edu.ifmg.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private Integer parcelas;

    @Column(nullable = false)
    private boolean faturado;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @JsonIgnore
    @OneToMany(mappedBy = "fatura")
    private List<Transacao> transacoes = new ArrayList<>();
}
