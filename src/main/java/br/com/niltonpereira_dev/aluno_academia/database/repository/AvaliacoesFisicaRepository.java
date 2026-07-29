package br.com.niltonpereira_dev.aluno_academia.database.repository;

import br.com.niltonpereira_dev.aluno_academia.database.model.AvaliacoesFisicaEntity;
import br.com.niltonpereira_dev.aluno_academia.dto.AvaliacoesFisicasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface AvaliacoesFisicaRepository extends JpaRepository<AvaliacoesFisicaEntity, Integer> {

    @NativeQuery(value = """
        SELECT a.id AS idAluno,
               a.nome AS nomeAluno,
               af.id AS idAvaliacao,
               af.peso AS peso,
               af.altura AS altura,
               af.percentual_gordura_corporal AS percentualGorduraCorporal
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a
            ON a.avaliacao_fisica_id = af.id
        """)
    List<AvaliacoesFisicasProjection> getAllAvaliacoes();

    @NativeQuery(
            value = """
            SELECT a.id AS idAluno,
                   a.nome AS nomeAluno,
                   af.id AS idAvaliacao,
                   af.peso AS peso,
                   af.altura AS altura,
                   af.percentual_gordura_corporal AS percentualGorduraCorporal
            FROM avaliacoes_fisicas af
            INNER JOIN alunos a
                ON a.avaliacao_fisica_id = af.id
            """,
            countQuery = """
            SELECT COUNT(*)
            FROM avaliacoes_fisicas af
            INNER JOIN alunos a
                ON a.avaliacao_fisica_id = af.id
            """
    )
    Page<AvaliacoesFisicasProjection> getAllAvaliacoesPage(Pageable pageable);

}
