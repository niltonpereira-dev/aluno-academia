package br.com.niltonpereira_dev.aluno_academia.database.repository;

import br.com.niltonpereira_dev.aluno_academia.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunosEntity, Integer> {
}
