package br.com.niltonpereira_dev.aluno_academia.controller;


import br.com.niltonpereira_dev.aluno_academia.dto.TreinoDTO;
import br.com.niltonpereira_dev.aluno_academia.exception.NotFoundException;
import br.com.niltonpereira_dev.aluno_academia.service.TreinosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinosService treinosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDTO treinoDTO) throws NotFoundException {
        treinosService.criarTreino(treinoDTO);
    }
}
