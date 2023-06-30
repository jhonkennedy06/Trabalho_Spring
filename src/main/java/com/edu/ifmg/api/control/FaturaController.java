package com.edu.ifmg.api.control;

import com.edu.ifmg.domain.model.Fatura;
import com.edu.ifmg.domain.repository.FaturaRepository;
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
@RequestMapping("/fatura")
@RequiredArgsConstructor
public class FaturaController {

    private final FaturaRepository faturaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fatura> listar() {
        return faturaRepository.findAll();
    }

    // Método GET para buscar uma fatura pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Fatura> buscar(@PathVariable Long id) {
        Optional<Fatura> fatura = faturaRepository.findById(id);
        return fatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método POST para criar uma nova fatura
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fatura salvar(@RequestBody Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    // Método PUT para atualizar uma fatura existente
    @PutMapping("/{id}")
    public ResponseEntity<Fatura> atualizar(@PathVariable Long id, @RequestBody Fatura fatura) {
        Optional<Fatura> faturaAtual = faturaRepository.findById(id);
        if (faturaAtual.isPresent()) {
            BeanUtils.copyProperties(fatura, faturaAtual.get(), "id");
            Fatura faturaAtualizada = faturaRepository.save(faturaAtual.get());
            return ResponseEntity.ok(faturaAtualizada);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fatura> remover(@PathVariable Long id) {
        try {
            Optional<Fatura> fatura = faturaRepository.findById(id);
            if (fatura.isPresent()) {
                faturaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
