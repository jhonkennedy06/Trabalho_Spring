package com.edu.ifmg.domain.repository;

import com.edu.ifmg.domain.model.Categoria;
import com.edu.ifmg.domain.model.MetaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaCategoriaRepository extends JpaRepository<MetaCategoria, Long> {
    MetaCategoria findByCategoria(Categoria categoria);
    //exemplo= localhost:8080/categoria?Lazer
}
