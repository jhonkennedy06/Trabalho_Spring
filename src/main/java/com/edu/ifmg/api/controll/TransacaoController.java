package com.edu.ifmg.api.controll;

import com.edu.ifmg.domain.model.Transacao;
import com.edu.ifmg.domain.repository.TransacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    // Método GET para listar todas as transações
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Transacao> listar() {
        return transacaoRepository.findAll();
    }

    // Método GET para buscar uma transação pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscar(@PathVariable Long id) {
        Optional<Transacao> t = transacaoRepository.findById(id);
        if (t.isPresent())
            return ResponseEntity.ok(t.get());
        return ResponseEntity.notFound().build();
    }

    // Método POST para criar uma nova transação
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao salvar(@RequestBody Transacao transacao) {

        return transacaoRepository.save(transacao);
    }

    // Método PUT para atualizar uma transação existente
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable Long id, @RequestBody Transacao transacao) {
        Optional<Transacao> transacaoAtual = transacaoRepository.findById(id);
        if (transacaoAtual.isPresent()) {
            BeanUtils.copyProperties(transacao, transacaoAtual.get(), "id", "data");
            Transacao transacaoA = transacaoRepository.save(transacaoAtual.get());
            return ResponseEntity.ok(transacaoA);
        }

        return ResponseEntity.notFound().build();
    }

    // Método DELETE para excluir uma transação existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Transacao> remover(@PathVariable Long id) {

        try {
            Optional<Transacao> t = transacaoRepository.findById(id);
            if (t.isPresent()) {
                transacaoRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
