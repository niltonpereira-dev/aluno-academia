package br.com.niltonpereira_dev.aluno_academia.service;



import br.com.niltonpereira_dev.aluno_academia.database.model.AlunosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.model.AvaliacoesFisicaEntity;
import br.com.niltonpereira_dev.aluno_academia.database.model.TreinosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.repository.AlunoRepository;
import br.com.niltonpereira_dev.aluno_academia.database.repository.AvaliacoesFisicaRepository;
import br.com.niltonpereira_dev.aluno_academia.database.repository.TreinosRepository;
import br.com.niltonpereira_dev.aluno_academia.dto.AlunoDTO;
import br.com.niltonpereira_dev.aluno_academia.exception.BadRequestException;
import br.com.niltonpereira_dev.aluno_academia.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final AvaliacoesFisicaRepository avaliacoesFisicaRepository;
    private final TreinosRepository treinosRepository;
    private final AlunoRepository alunoRepository;

    public void criarAluno(AlunoDTO alunoDTO) throws BadRequestException{
        AlunosEntity aluno = alunoRepository.findByEmail(alunoDTO.getEmail())
                .orElse(null);

        if (aluno != null){
            throw new BadRequestException("Aluno já cadastrado com este email.");
        }

        alunoRepository.save(AlunosEntity.builder()
                        .nome(alunoDTO.getNome())
                        .email(alunoDTO.getEmail())
                         .build());

    }

    public AvaliacoesFisicaEntity getAlunoAvaliacao(Integer alunoId) throws NotFoundException{
        AlunosEntity aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado."));

        AvaliacoesFisicaEntity avaliacao = aluno.getAvaliacoesFisica();
        if(avaliacao == null){
            throw new NotFoundException("Avaliação física não encontrada para este aluno");
        }

        return  avaliacao;
    }

    @Transactional
    public void deletarAluno(Integer alunoId) throws NotFoundException {

        //Transacao begin
        AlunosEntity aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        // deletar treinos do aluno
        List<Integer> treinosAlunoIds = aluno.getTreinos()
                .stream()
                .map(TreinosEntity::getId)
                .toList();

        treinosRepository.deleteAllById(treinosAlunoIds);

        // deletar o aluno
        alunoRepository.deleteById(alunoId);

        // deletar avaliacao fisica
        avaliacoesFisicaRepository.deleteById(aluno.getAvaliacoesFisica().getId());

        // transacao commit
    }


}
