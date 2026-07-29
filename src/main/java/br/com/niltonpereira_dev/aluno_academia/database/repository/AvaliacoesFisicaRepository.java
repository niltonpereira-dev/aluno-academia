package br.com.niltonpereira_dev.aluno_academia.database.repository;

import br.com.niltonpereira_dev.aluno_academia.database.model.AvaliacoesFisicaEntity;
import br.com.niltonpereira_dev.aluno_academia.dto.AvaliacoesFisicasProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface AvaliacoesFisicaRepository extends JpaRepository<AvaliacoesFisicaEntity, Integer> {

    @NativeQuery(value = """
    SELECT a.id idAluno,
           a.nome                        nomeAluno,
           af.id                         idAvaliacao,
           af.peso                       peso,
           af.altura                     altura,
           af.percentual_gordura_corporal percentualGorduraCorporal
    FROM avaliacoes_fisicas af 
        INNER JOIN alunos a 
    ON a.avaliacao_fisica_id = af.id

""")
    List<AvaliacoesFisicasProjection> getAllAvaliacoes();

}

