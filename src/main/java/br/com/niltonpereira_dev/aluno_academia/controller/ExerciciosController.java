package br.com.niltonpereira_dev.aluno_academia.controller;

import br.com.niltonpereira_dev.aluno_academia.database.model.ExerciciosEntity;
import br.com.niltonpereira_dev.aluno_academia.dto.ExerciciosDTO;
import br.com.niltonpereira_dev.aluno_academia.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping()
    public ResponseEntity<List<ExerciciosEntity>> listaExercicios(){
        return ResponseEntity.ok(exerciciosService.listaDeExercicios());
    }

    @PostMapping()
    public ResponseEntity<Void> salverExercicios(@Valid @RequestBody ExerciciosDTO exerciciosDTO){
       exerciciosService.salvar(exerciciosDTO);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/grupos/{grupoMuscular}")
    public ResponseEntity<List<ExerciciosEntity>> exerciciosGrupoMuscular(@PathVariable String grupoMuscular){
        return ResponseEntity.ok(exerciciosService.listaGrupoMuscular(grupoMuscular));
    }
}
