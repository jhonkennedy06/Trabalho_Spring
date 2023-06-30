package com.edu.ifmg.domain.repository;

import com.edu.ifmg.domain.model.MetaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaCategoriaRepository extends JpaRepository<MetaCategoria,Long> {
}
