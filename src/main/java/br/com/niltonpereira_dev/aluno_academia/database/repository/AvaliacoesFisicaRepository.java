package br.com.niltonpereira_dev.aluno_academia.database.repository;

import br.com.niltonpereira_dev.aluno_academia.database.model.AvaliacoesFisicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacoesFisicaRepository extends JpaRepository<AvaliacoesFisicaEntity, Integer> {
}
