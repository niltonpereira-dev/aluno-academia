package br.com.niltonpereira_dev.aluno_academia.service;



import br.com.niltonpereira_dev.aluno_academia.database.model.AlunosEntity;
import br.com.niltonpereira_dev.aluno_academia.database.repository.AlunoRepository;
import br.com.niltonpereira_dev.aluno_academia.dto.AlunoDTO;
import br.com.niltonpereira_dev.aluno_academia.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunosService {

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
}
