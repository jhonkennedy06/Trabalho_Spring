package com.edu.ifmg.api.control;

import com.edu.ifmg.domain.model.MetaCategoria;
import com.edu.ifmg.domain.repository.MetaCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meta-categoria")
@RequiredArgsConstructor
public class MetaCategoriaController {
    
    private final MetaCategoriaRepository metaCategoriaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MetaCategoria> listar() {
        return metaCategoriaRepository.findAll();
    }

    // Método GET para buscar uma metaCategoria pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<MetaCategoria> buscar(@PathVariable Long id) {
        Optional<MetaCategoria> metaCategoria = metaCategoriaRepository.findById(id);
        return metaCategoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método POST para criar uma nova metaCategoria
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MetaCategoria salvar(@RequestBody MetaCategoria metaCategoria) {
        return metaCategoriaRepository.save(metaCategoria);
    }

    // Método PUT para atualizar uma metaCategoria existente
    @PutMapping("/{id}")
    public ResponseEntity<MetaCategoria> atualizar(@PathVariable Long id, @RequestBody MetaCategoria metaCategoria) {
        Optional<MetaCategoria> metaCategoriaAtual = metaCategoriaRepository.findById(id);
        if (metaCategoriaAtual.isPresent()) {
            BeanUtils.copyProperties(metaCategoria, metaCategoriaAtual.get(), "id");
            MetaCategoria metaCategoriaAtualizada = metaCategoriaRepository.save(metaCategoriaAtual.get());
            return ResponseEntity.ok(metaCategoriaAtualizada);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MetaCategoria> remover(@PathVariable Long id) {
        try {
            Optional<MetaCategoria> metaCategoria = metaCategoriaRepository.findById(id);
            if (metaCategoria.isPresent()) {
                metaCategoriaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
