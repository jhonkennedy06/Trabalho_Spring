package com.edu.ifmg.api.control;

import com.edu.ifmg.domain.model.Categoria;
import com.edu.ifmg.domain.repository.CategoriaRepository;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Método GET para listar todas as categorias
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    // Método GET para buscar uma categoria pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent())
            return ResponseEntity.ok(categoria.get());
        return ResponseEntity.notFound().build();
    }

    // Método POST para criar uma nova categoria
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Método PUT para atualizar uma categoria existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> categoriaAtual = categoriaRepository.findById(id);
        if (categoriaAtual.isPresent()) {
            BeanUtils.copyProperties(categoria, categoriaAtual.get(), "id");
            Categoria categoriaAtualizada = categoriaRepository.save(categoriaAtual.get());
            return ResponseEntity.ok(categoriaAtualizada);
        }

        return ResponseEntity.notFound().build();
    }

    // Método DELETE para excluir uma categoria existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> remover(@PathVariable Long id) {
        try {
            Optional<Categoria> categoria = categoriaRepository.findById(id);
            if (categoria.isPresent()) {
                categoriaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
