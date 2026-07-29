package br.com.niltonpereira_dev.aluno_academia.controller;


import br.com.niltonpereira_dev.aluno_academia.database.model.AvaliacoesFisicaEntity;
import br.com.niltonpereira_dev.aluno_academia.dto.AlunoDTO;
import br.com.niltonpereira_dev.aluno_academia.exception.BadRequestException;
import br.com.niltonpereira_dev.aluno_academia.exception.NotFoundException;
import br.com.niltonpereira_dev.aluno_academia.service.AlunosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDTO alunoDTO) throws BadRequestException {
        alunosService.criarAluno(alunoDTO);
    }

    @GetMapping("{alunoId}/avaliacao")
    public AvaliacoesFisicaEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunosService.getAlunoAvaliacao(alunoId);
    }
}
