package br.com.niltonpereira_dev.aluno_academia.service;

import br.com.niltonpereira_dev.aluno_academia.database.model.AlunosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.model.AvaliacoesFisicaEntity;
import br.com.niltonpereira_dev.aluno_academia.database.repository.AlunoRepository;
import br.com.niltonpereira_dev.aluno_academia.database.repository.AvaliacoesFisicaRepository;
import br.com.niltonpereira_dev.aluno_academia.dto.AvaliacaoFisicaDTO;
import br.com.niltonpereira_dev.aluno_academia.dto.AvaliacoesFisicasProjection;
import br.com.niltonpereira_dev.aluno_academia.exception.BadRequestException;
import br.com.niltonpereira_dev.aluno_academia.exception.NotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacoesFisicaService {

    private final AlunoRepository alunoRepository;
    private final AvaliacoesFisicaRepository avaliacoesFisicaRepository;


    public  void criarAvaliacaoFisica(AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunoRepository.findByFetch(avaliacaoFisicaDTO.getAlunoID())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicaEntity avaliacaoFisica = aluno.getAvaliacoesFisica();
        if (avaliacaoFisica != null){
            throw new BadRequestException("Avaliação fisica já cadastrada para este aluno");
        }

        avaliacaoFisica = AvaliacoesFisicaEntity.builder()
                .peso(avaliacaoFisicaDTO.getPeso())
                .altura(avaliacaoFisicaDTO.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDTO.getPercentualGorduraCorporal())
                .build();


        aluno.setAvaliacoesFisica(avaliacaoFisica);
        alunoRepository.save(aluno);
    }

    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacoesFisicaRepository.getAllAvaliacoes();
    }


}
