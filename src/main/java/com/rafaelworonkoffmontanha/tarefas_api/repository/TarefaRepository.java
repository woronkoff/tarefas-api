package com.rafaelworonkoffmontanha.tarefas_api.repository;

import com.rafaelworonkoffmontanha.tarefas_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
