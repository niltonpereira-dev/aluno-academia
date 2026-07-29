package br.com.niltonpereira_dev.aluno_academia.database.repository;

import br.com.niltonpereira_dev.aluno_academia.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);

    @Query("""
        SELECT a
        FROM AlunosEntity a
        LEFT JOIN FETCH a.avaliacoesFisica
        WHERE a.id = :alunoID
        """)
    Optional<AlunosEntity> findByFetch(@Param("alunoID") Integer alunoID);
}