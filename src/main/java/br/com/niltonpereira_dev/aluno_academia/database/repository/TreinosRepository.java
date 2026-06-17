package br.com.niltonpereira_dev.aluno_academia.database.repository;

import br.com.niltonpereira_dev.aluno_academia.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinosRepository extends JpaRepository<TreinosEntity, Integer> {
}
