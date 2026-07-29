package br.com.niltonpereira_dev.aluno_academia.controller;

import br.com.niltonpereira_dev.aluno_academia.dto.AvaliacaoFisicaDTO;
import br.com.niltonpereira_dev.aluno_academia.dto.AvaliacoesFisicasProjection;
import br.com.niltonpereira_dev.aluno_academia.exception.BadRequestException;
import br.com.niltonpereira_dev.aluno_academia.exception.NotFoundException;
import br.com.niltonpereira_dev.aluno_academia.service.AvaliacoesFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacoesFisicasController {

    private final AvaliacoesFisicaService avaliacoesFisicaService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        avaliacoesFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacoesFisicaService.getAllAvaliacoes();
    }
}
