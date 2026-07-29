package br.com.niltonpereira_dev.aluno_academia.service;

import br.com.niltonpereira_dev.aluno_academia.database.model.AlunosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.model.ExerciciosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.model.TreinosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.repository.AlunoRepository;
import br.com.niltonpereira_dev.aluno_academia.database.repository.ExerciciosRepository;
import br.com.niltonpereira_dev.aluno_academia.database.repository.TreinosRepository;
import br.com.niltonpereira_dev.aluno_academia.dto.TreinoDTO;
import br.com.niltonpereira_dev.aluno_academia.exception.BadRequestException;
import br.com.niltonpereira_dev.aluno_academia.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinosService {

    private final TreinosRepository treinosRepository;
    private final AlunoRepository alunoRepository;
    private final ExerciciosRepository exerciciosRepository;

    public void criarTreino(TreinoDTO treinoDTO) throws NotFoundException{
        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunoRepository.findById(treinoDTO.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado."));

        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDTO.getNome(), treinoDTO.getAlunoId())
                .orElse(null);

        if (treino != null){
            throw new BadRequestException("Já existe um treino com esse nome para esse aluno");
        }

        for (Integer exercicioId : treinoDTO.getExerciciosIds()){
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("Exercício %s não encontrado", exercicioId)));

            exercicios.add(exercicio);
        }

        treino = TreinosEntity.builder()
                .nome(treinoDTO.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinosRepository.save(treino);
    }
}
