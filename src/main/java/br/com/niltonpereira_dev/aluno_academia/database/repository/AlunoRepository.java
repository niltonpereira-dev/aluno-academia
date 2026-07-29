package br.com.niltonpereira_dev.aluno_academia.database.repository;

import br.com.niltonpereira_dev.aluno_academia.database.model.AlunosEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);

    @Query(value = "SELECT a FROM AlunosEntity a JOIN FETCH a.avaliacaoFisica")
    Optional<AlunosEntity> findByFetch(@NotNull Integer alunoID);
}
