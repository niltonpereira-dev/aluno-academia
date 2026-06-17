package br.com.niltonpereira_dev.aluno_academia.service;

import br.com.niltonpereira_dev.aluno_academia.database.model.ExerciciosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.repository.ExerciciosRepository;
import br.com.niltonpereira_dev.aluno_academia.dto.ExerciciosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final ExerciciosRepository exerciciosRepository;


    public List<ExerciciosEntity> listaDeExercicios(){
        return exerciciosRepository.findAll();
    }

    public void salvar(ExerciciosDTO exerciciosDTO){
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exerciciosDTO.getNome())
                .grupoMuscular(exerciciosDTO.getGrupoMuscular())
                .build();
        exerciciosRepository.save(exercicio);
    }
}
