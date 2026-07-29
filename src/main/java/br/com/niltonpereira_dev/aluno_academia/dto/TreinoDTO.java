package br.com.niltonpereira_dev.aluno_academia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TreinoDTO {

    @NotNull
    private Integer alunoId;

    @NotBlank
    private String nome;

    @NotEmpty
    private List<Integer> exerciciosIds;
}
