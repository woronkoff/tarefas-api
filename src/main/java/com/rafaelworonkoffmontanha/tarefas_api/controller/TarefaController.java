package com.rafaelworonkoffmontanha.tarefas_api.controller;

import com.rafaelworonkoffmontanha.tarefas_api.model.Tarefa;
import com.rafaelworonkoffmontanha.tarefas_api.repository.TarefaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    // Criar tarefa
    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        Tarefa salva = repository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // Listar todas
    @GetMapping
    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
    }

    // Atualizar por ID
    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa dados) {
        Tarefa existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));

        existente.setNome(dados.getNome());
        existente.setDataEntrega(dados.getDataEntrega());
        existente.setResponsavel(dados.getResponsavel());

        return repository.save(existente);
    }

    // Remover por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
